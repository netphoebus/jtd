/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package mina;

import java.io.Serializable;
import java.nio.ByteOrder;
import java.util.Iterator;

import org.apache.mina.core.buffer.BufferDataException;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 * A {@link ProtocolDecoder} which deserializes {@link Serializable} Java
 * objects using {@link IoBuffer#getObject(ClassLoader)}.
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public class MyBytesDecoder extends CumulativeProtocolDecoder {
    private final ClassLoader classLoader;

    private int maxObjectSize = 1048576; // 1MB

    /**
     * Creates a new instance with the {@link ClassLoader} of
     * the current thread.
     */
    public MyBytesDecoder() {
        this(Thread.currentThread().getContextClassLoader());
    }

    /**
     * Creates a new instance with the specified {@link ClassLoader}.
     */
    public MyBytesDecoder(ClassLoader classLoader) {
        if (classLoader == null) {
            throw new IllegalArgumentException("classLoader");
        }
        this.classLoader = classLoader;
    }

    /**
     * Returns the allowed maximum size of the object to be decoded.
     * If the size of the object to be decoded exceeds this value, this
     * decoder will throw a {@link BufferDataException}.  The default
     * value is <tt>1048576</tt> (1MB).
     */
    public int getMaxObjectSize() {
        return maxObjectSize;
    }

    /**
     * Sets the allowed maximum size of the object to be decoded.
     * If the size of the object to be decoded exceeds this value, this
     * decoder will throw a {@link BufferDataException}.  The default
     * value is <tt>1048576</tt> (1MB).
     */
    public void setMaxObjectSize(int maxObjectSize) {
        if (maxObjectSize <= 0) {
            throw new IllegalArgumentException("maxObjectSize: " + maxObjectSize);
        }

        this.maxObjectSize = maxObjectSize;
    }

    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        /*if (!in.prefixedDataAvailable(2, maxObjectSize)) {
            return false;
        }
        

        out.write(in.getObject(classLoader));
        */
    	in.order(ByteOrder.LITTLE_ENDIAN);
    	
    	
    	
//    	int i = (in.getHexDump().length()+1)/3;
//    	byte[] bs = new byte[i];
//    	in.get(bs);
//    	//byte cur_b = in.get(); //这个是byte  
//    	//int cur_i = cur_b & 0xff; //做运算时要转成整形  
//    	out.write(in);
//        return true;
//    }
    
    	in.order(ByteOrder.LITTLE_ENDIAN);

    	if(in.remaining()<4)//这里很关键，网上很多代码都没有这句，是用来当拆包时候剩余长度小于4的时候的保护，不加就出错咯 
    	{ 
    	return false;
    	}
    	        if (in.remaining() > 1) {
    	         
    	            in.mark();//标记当前位置，以便reset
    	            System.out.println("test" + in.limit()+"========"+in.getHexDump()); 
    	            
    	            int length = in.limit();
    	            
    	            
    	            
    	            if(length < 0 ){//如果消息内容不够，则重置，相当于不读取size   
    	            System.out.println("package notenough  left="+in.remaining()+" length="+length);
    	                in.reset();   
    	                return false;//接收新数据，以拼凑成完整数据   
    	            }else{  
    	            System.out.println("package ="+in.toString()); 
    	           // in.getInt();
    	             	
//    	            int i = in.limit();
//    	        	byte[] bs = new byte[i];
//    	        	in.get(bs);
    	            
    	                byte[] bytes = new byte[length]; 
    	                in.get(bytes, 0, length);   
    	                int cmd_length = ((bytes[8]&0xff)<<8)+(bytes[9]&0xff)+4;
    	                
    	                in.reset();
//    	                if(cmd_length<length){
//    	                	in.reset(); 
//    	                	return false;
//    	                }
    	              //  String str = new String(bytes,"UTF-8");    
    	                if(null != bytes && bytes.length > 0){   
    	                	byte[] nbytes = new byte[cmd_length];
    	                	//String strOut = DateSecret.decryptDES(str);//别看这里的处理，这里是我的数据包解密算法~你可以直接拿str当数据
    	                	in.get(nbytes, 0, cmd_length);
    	                	out.write(IoBuffer.wrap(nbytes)); 
    	                	
    	                }   
    	                if(in.remaining() > 0){//如果读取内容后还粘了包，就让父类再给一次，进行下一次解析  
    	                System.out.println("package left="+in.remaining()+" data="+in.toString()); 
    	                	//return true;
    	                } 
    	                return true;
    	                //这里有两种情况1：没数据了，那么就结束当前调用，有数据就再次调用
    	            }   
    	        }   
    	        return false;//处理成功，让父类进行接收下个包   
    }
    
}
