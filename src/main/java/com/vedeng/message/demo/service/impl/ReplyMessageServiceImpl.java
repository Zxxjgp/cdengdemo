package com.vedeng.message.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vedeng.message.demo.dao.ReplyMessageDao;
import com.vedeng.message.demo.dao.UserDao;
import com.vedeng.message.demo.model.ReplyMessage;
import com.vedeng.message.demo.model.User;
import com.vedeng.message.demo.service.ReplyMessageService;
import com.vedeng.message.demo.utils.DateUtils;
import com.vedeng.message.demo.utils.ObjectUtils;
import com.vedeng.message.demo.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能描述
 *
 * @author Bert
 * @date 2018/11/6
 * @Description:
 * @version:
 */
@Service
public class ReplyMessageServiceImpl extends ServiceImpl<ReplyMessageDao, ReplyMessage> implements ReplyMessageService {

    @Resource
    private UserDao userDao;
    /**
     * 得到一条帖子的留言
     * @param messageId
     * @return
     */
    @Override
    public Page<ReplyMessage> getReplyMessage(Page page,Integer messageId) {
        //查询留言
        List<ReplyMessage> list = baseMapper.getReplyMessage(page,messageId);
        //判断留言是否存在，如果留言存在看有没有，如果留言存在看有没有回复留言的存在
        if (list.size() >= 1){
            //对所有留言的
            list.stream().forEach(x ->{
                if (x.getReplyReplyId() != 0){
                    //查询留言的回复信息
                    x.setAddTimes(DateUtils.stampToDate(x.getAddTime().toString()));
                    //查询对留言的回复
                    List<ReplyMessage> byReplyId = baseMapper.findByReplyId(x.getReplyReplyId());
                    //判断留言是否存在
                    if (list.size() >= 1){
                        /**
                         * 回复留言的对照处理
                         */
                        for (int i = 0 ; i <list.size() ; i++) {
                            /**
                             * 将回复的留言相对应的位置
                             */
                            Integer integer = list.get(i).getReplyId();
                            list.stream().forEach( m -> {
                                if ( integer== m.getReplyReplyId()){
                                    //去定位
                                    for (ReplyMessage r : list) {
                                        if (r.getReplyId() == integer){
                                            r.setList(byReplyId);
                                        }
                                    }
                                    //时间的转换
                                    x.setAddTimes(DateUtils.stampToDate(x.getAddTime().toString()));
                                }
                            } );
                        }

                        //查询对留言回复人
                        User user = userDao.selectById(x.getCreator());
                        //判断留言人是否存在，如果存在就将他的姓名冗余
                        if (!ObjectUtils.isEmpty(user)){
                            x.setCreators(user.getUserName());
                        }
                    }
                }
            });
            //将回复的留言全部干掉
            List<ReplyMessage> collect = list.stream().filter(x -> x.getReplyReplyId() == 0).collect(Collectors.toList());
            //判断是否存在
            if (collect.size() >= 0){
                //进行姓名的冗余
                collect.stream().forEach(a -> {
                    a.setAddTimes(DateUtils.stampToDate(a.getAddTime().toString()));
                });
            }
            page.setCount(page.getTotal());
            page.setList(collect);
        }
        return page;
    }

    /**
     * 留言
     * @param entity
     * @return
     */
    @Override
    public boolean insertOrUpdate(ReplyMessage entity) {
        entity.setAddTime(System.currentTimeMillis());
        /**
         * 创建人
         */
        entity.setCreator(1);
        return super.insertOrUpdate(entity);
    }
}
