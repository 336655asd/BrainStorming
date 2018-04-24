/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;

/**
 *
 * @author C
 */
public class dwr_interface {
    
    public int mg_center() throws IOException
    {
        message_center mc = new message_center("cc");
        return mc.num_message;
    }
    
    public String[] mc_analysis() throws IOException
    {
        message_center mc = new message_center("cc");
        
        mc.analysis();
        System.out.print("共有未读消息");
        System.out.print(mc.message_read_q.size());
        String mgString[];
        int num_q=mc.message_read_q.size();
        mgString = new String[num_q];
        for(int i=0;i<num_q;i++)
        {
            mgString[i]=mc.message_read_q.get(i).info;
        }
        return mgString;
    }
    
    public int rwrite() throws IOException
    {
        message_center mc = new message_center("cc");
        mc.rwrite();
        return 0;
    }
    
}
