package me.gacl.domain;

import me.gacl.domain.Subject;

/**
 * Created by keruyun on 2017/10/27.
 */
public class SubjectImpl implements Subject
{
    @Override
    public void rent()
    {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str)
    {
        System.out.println("hello: " + str);
    }
}