package com.vedeng.message.demo.webService;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;

public class HelloWorldClient {
  public static void main(String[] argv) {

    Service service = new Service();
    String url = "http://127.0.0.1:8002/Service/ServiceHello?wsdl";
    String name = "Bert";
    try {
      Call call = (Call)service.createCall();
      call.setTargetEndpointAddress(new java.net.URL(url));
      call.setOperationName(new QName("http://webService.demo.message.vedeng.com","getValue"));
      call.addParameter(new QName(name),org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
      //call.setUseSOAPAction(true);
      String temp = name;
      call.setReturnType(org.apache.axis.encoding.XMLType.SOAP_STRING);
      String result = (String)call.invoke(new Object[]{temp});

      System.out.println(result);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}