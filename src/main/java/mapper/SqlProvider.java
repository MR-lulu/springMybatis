package mapper;

/**
 * Created by keruyun on 2017/11/1.
 */
public class SqlProvider {
    public SqlProvider(){
        System.out.println("每次都会调用构造方法！！！！！");
    }
    public String selectUserByName(String name){
        String sql = "select * from users where name = '" +name +"'";
        return sql;
    }
}
