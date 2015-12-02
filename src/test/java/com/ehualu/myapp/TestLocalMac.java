package com.ehualu.myapp;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.Test;

public class TestLocalMac {

	private static void getLocalMac(InetAddress ia) throws SocketException {
		// TODO Auto-generated method stub
		//获取网卡，获取地址
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
		System.out.println("mac数组长度："+mac.length);
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<mac.length; i++) {
			if(i!=0) {
				sb.append("-");
			}
			//字节转换为整数
			int temp = mac[i]&0xff;
			String str = Integer.toHexString(temp);
			System.out.println("每8位:"+str);
			if(str.length()==1) {
				sb.append("0"+str);
			}else {
				sb.append(str);
			}
		}
		System.out.println("本机MAC地址:"+sb.toString().toUpperCase());
	}
	
	@Test
	public void testGetLocalMac() throws UnknownHostException, SocketException{
		InetAddress ia = InetAddress.getLocalHost();
		System.out.println(ia);
		getLocalMac(ia);
	}
}
