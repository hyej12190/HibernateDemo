package com.example.hibernateTest.entity;

/*
    n+1 문제를 해결하기 위해 mapping interface 사용.
    userRepository 에 findall 을 재정의해서 사용
    쿼리를 보면 join 쿼리로 수행됨.

*/

public interface UserMapping {

    String getID();
    String getFIRST();
    String getLAST();
    String getEMAIL();
    String getPWD();
    
    UserGroup getUserGroup();

}