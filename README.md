# spring4_mybatis3_mysql_dynamic_paging
spring4 mybatis3 mysql dynamic procedure paging 

project info

eclipse,Maven,spring4,mybatis3,c3p0,mysql 

using mybatis plugin: 

MyBatis Velocity link:http://www.mybatis.org/velocity-scripting/index.html 

Mybatis spring link:http://www.mybatis.org/spring/ 

MyBatis Generator link:http://www.mybatis.org/generator/ 



PROCEDURE:dynamic_paging 

CREATE PROCEDURE  `dynamic_paging`(sql varchar(500),page_begin int,page_end int)

BEGIN

set @lowercase:=lower(sql);

if(!LOCATE('delete',@lowercase) && !LOCATE('drop',@lowercase) && !LOCATE('truncate',@lowercase) && !LOCATE('update',@lowercase) && !LOCATE('delete',@lowercase) && !LOCATE('alter',@lowercase) )then

set @temp:='';

if(LOCATE('select',tab))then

set @temp:=concat(tab,' limit ',page_begin,',',page_end);

PREPARE stmt FROM @temp;

EXECUTE stmt;

DEALLOCATE PREPARE stmt;

end if;

end if;

END 





table:user 

id   userName  userAge     userAddress     
1, '1--xkorey', 11, '1--this is a test b.'  
2, '2--xkorey', 12, '2--this is a test b.'  
3, '3--xkorey', 13, '3--this is a test b.'  
4, '4--xkorey', 14, '4--this is a test b.'  
5, '5--xkorey', 15, '5--this is a test b.'  
6, '6--xkorey', 16, '6--this is a test b.'  
7, '7--xkorey', 17, '7--this is a test b.'  
8, '8--xkorey', 18, '8--this is a test b.'  
9, '9--xkorey', 19, '9--this is a test b.'  
10, '10--xkorey', 20, '10--this is a test b.' 

table: fun_log

id  info         user_id  
1, '1--log info', 1  
2, '2--log info', 1  
3, '3--log info', 1  
4, '4--log info', 1  
5, '5--log info', 1  
6, '6--log info', 1  
7, '7--log info', 1  
8, '8--log info', 1  
9, '9--log info', 1  
10, '10--log info', 1  

Userservice  

public interface UserService {  
/** 
     * paging get user info 
     * @param begin begin position
     * @param size  fetch size 
     * @return 
     */  
     public List<User> getUserByList(Integer begin,Integer size);  
/** 
     * paging get user log info
     * @param userId user id
     * @param begin begin position
     * @param size fetch size
     * @return 
     */  
     public List<FunLog> getUserLogsList(Integer userId,Integer begin,Integer size);  
}  



List<User> users = userService.getUserByList(0,3);

Mybatis log:

==>  Preparing: CALL dynamic_paging('select * from user',?,?)   
==> Parameters: 0(Integer), 3(Integer)  
<==    Columns: id, userName, userAge, userAddress  
<==        Row: 1, 1--xkorey, 11, 1--this is a test b.  
<==        Row: 2, 2--xkorey, 12, 2--this is a test b.  
<==        Row: 3, 3--xkorey, 13, 3--this is a test b.  
<==      Total: 3  
<==    Updates: 0  


List<FunLog> logs = userService.getUserLogsList(1,0,2);

Mybatis log:

==>  Preparing: CALL dynamic_paging(?,?,?)   
==> Parameters: SELECT * FROM user,fun_log f where f.user_id=user.id and user.id=1(String), 0(Integer), 2(Integer)  
<==    Columns: id, userName, userAge, userAddress, id, info, user_id  
<==        Row: 1, 1--xkorey, 11, 1--this is a test b., 1, <<BLOB>>, 1  
<==        Row: 1, 1--xkorey, 11, 1--this is a test b., 2, <<BLOB>>, 1  
<==      Total: 2  
<==    Updates: 0  


more info 

link: http://xkorey.iteye.com/blog/2367209
link: http://xkorey.iteye.com/blog/2367212
link: http://xkorey.iteye.com/blog/2367215


