/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONObject;

/**
 *
 * @author C
 */
public class message_center {
    
    public int num_message=0;
    //信息列表
    public message message_list[];
    public List<message> message_read_q= new ArrayList();
    public List<message> message_read_p= new ArrayList();
    public List<message> message_left= new ArrayList();
    public String file_dir="";
    public String user="";
    public int array_info[];

    //从cookies中读取用户名
    public message_center(String userString) throws IOException {
       
        this.user=userString;
        this.file_dir="C:\\brain_storm\\users\\"+this.user+"\\message.txt";
        this.messageReader();
        this.array_info=new int[2];
    }
    
    public int messageReader() throws FileNotFoundException, IOException
    {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file_dir)); // 建立一个输入流对象reader  
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
        String line = "";  
        String str="";
        do{
            line = br.readLine();
            if (line==null)
            {
                System.out.println("this line is null");
            }
            else
            {
            System.out.println(line);
            str+=line+"\n";
            }
        }while(line != null);
        reader.close();
        System.out.println(str);
        String jsondata[];
        jsondata = str.split("\n");
        /*为什么会从0开始*/
        //System.out.println(jsondata[1]);
        //json格式读取
        num_message=jsondata.length;
        
        message_list=new message[num_message];
        for(int i=0;i<num_message;i++)
        {
            if (jsondata[i]==null)
            {
                System.out.println("暂无更多消息");
            }
            else
            {
            System.out.println(jsondata[i]);
            JSONObject jsonObject =JSONObject.fromObject(jsondata[i]);
            String receiver=jsonObject.getString("receiver");
            String sender=jsonObject.getString("sender");
            String info=jsonObject.getString("infomation");
            String type=jsonObject.getString("type");
            String read=jsonObject.getString("read");
            message_list[i]=new message(receiver,sender,info,type,read);
            System.out.println(message_list[i].type);
            }
        }
        return this.num_message;
    }
    
    public int toScreen()
    {
        
        return 0;
    }
    
    public int analysis()
    {
        for(int i=0;i<this.num_message;i++)
        {
            System.out.println("消息类型");
            System.out.println(this.message_list[i].type);
            if(this.message_list[i].type.equals("examineQ_notice") && message_list[i].read.equals("false"))
            {

                //待审核消息
                array_info[0]+=1;
                message_read_q.add(this.message_list[i]);
            }
            else if(this.message_list[i].type.equals("private_letter") && message_list[i].read.equals("false"))
            {

                //私信
                array_info[1]+=1;
                message_read_p.add(this.message_list[i]);
                
            }
            else
            {
                //已处理信息
                message_left.add(this.message_list[i]);
            }
        }
        return 0;
    }
    
    //对已读消息全体进行重写，暂时没有分单个消息是否已读
    public int rwrite() throws IOException
    {
        FileWriter fileWriter = new FileWriter(this.file_dir);
        String content="";
        for(int i=0;i<this.num_message;i++)
        {
        content="{\"receiver\":\""+this.message_list[i].receiver
                +"\",\"sender\":\""+this.message_list[i].sender
                +"\",\"infomation\":\""+this.message_list[i].info
                +"\",\"type\":\""+this.message_list[i].type
                +"\",\"read\":\"true\""
                +"}\r\n";
        fileWriter.write(content);
        }
        fileWriter.close();
        return 0;
    }
    
    //私信发送，从输入框中读入
    public int sent_message(String receiverString,String content) throws IOException
    {
        message mg = new message(receiverString, this.user, receiverString, this.file_dir, "false");
        mg.messageSend();
        return 0;
    }
    
    
}
