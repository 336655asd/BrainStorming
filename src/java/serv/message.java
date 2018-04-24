/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import net.sf.json.JSONObject;


/**
 *
 * @author C
 */
public class message {
    public String info="";
    public String receiver="";
    public String sender="";
    public String type="";
    public String file_dir="";
    public String read="";
    public int num_message=0;
    public message message_list[];
    
    public message(String receiverString,String senderString,String infoString,String typeString,String readString) {
        this.info=infoString;
        this.receiver=receiverString;
        this.sender=senderString;
        this.type=typeString;
        this.file_dir="C:\\brain_storm\\users\\"+this.receiver+"\\message.txt";
        this.read=readString;
    }
    
    public int messageSend() throws IOException
    {
        String file_spuerDir="C:\\brain_storm\\users\\"+this.receiver;
        File file = new File(file_spuerDir);
        if(!file.exists())
        {
            file.mkdir();
        }
        FileWriter fileWriter = new FileWriter(this.file_dir,true);
        String content="";
        content="{\"receiver\":\""+this.receiver
                +"\",\"sender\":\""+this.sender
                +"\",\"infomation\":\""+this.info
                +"\",\"type\":\""+this.type
                +"\",\"read\":\"false\""
                +"}\r\n";
        fileWriter.write(content);
        fileWriter.close();
        
        return 0;
    }
    
   
    
    public int decode()
    {
        
        return 0;
    }
    
}
