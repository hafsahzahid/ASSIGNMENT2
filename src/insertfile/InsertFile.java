/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package insertfile;


import java.io.*;
import java.sql.*;
import java.util.*;

public class InsertFile{
public static void main(String[]args){
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
Statement st=con.createStatement();

FileInputStream fstream = new FileInputStream("C:\\student.txt");
DataInputStream in = new DataInputStream(fstream);
BufferedReader br = new BufferedReader(new InputStreamReader(in));
String strLine;
ArrayList list=new ArrayList();
while ((strLine = br.readLine()) != null){
list.add(strLine);
}
Iterator itr;
for (itr=list.iterator(); itr.hasNext(); ){
String str=itr.next().toString();
String [] splitSt =str.split(" ");
String id="",name="",course="",deptt="";
for (int i = 0 ; i < splitSt.length ; i++) {
id=splitSt[0];
name=splitSt[1];
course=splitSt[2];
deptt=splitSt[3];
}

int k=st.executeUpdate("insert into software(id,name,course,department) values('"+id+"','"+name+"','"+course+"','"+deptt+"')");

}
}
catch(Exception e){}
}
}