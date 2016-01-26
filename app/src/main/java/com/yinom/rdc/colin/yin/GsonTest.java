package com.yinom.rdc.colin.yin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yinom.rdc.colin.yin.bean.Student;

import java.util.List;

/**
 * Created by Colin on 1/22/2016.
 */
public class GsonTest {
    public static void main(String[] args) {
        Gson gson = new Gson();
      /*  Student stu=new Student(1,"zhangsan",23);
        String json=gson.toJson(stu);
        System.out.println(json);*/

      /*  List<Student> stus=new ArrayList<Student>();
        stus.add(new Student(1,"lisi",22));
        stus.add(new Student(2,"lihua",25));
        String json=gson.toJson(stus);
        System.out.println(json);*/

        /*String json="{\"name\":\"lisi\",\"id\":1,\"age\":22}";
        gson.fromJson(json,Student.class);
        System.out.println("name="+stu.name+"==="+stu.age);*/

        String json = "[{\"name\":\"lisi\",\"id\":1,\"age\":22},{\"name\":\"wangwu\",\"id\":1," +
                "\"age\":22}]";

        List<Student> stus = gson.fromJson(json, new TypeToken<List<Student>>() {
        }.getType());
        for (Student stu : stus) {
            System.out.println("name=" + stu.name + "===" + stu.age);
        }
    }
}


