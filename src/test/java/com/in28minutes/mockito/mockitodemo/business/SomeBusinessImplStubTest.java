package com.in28minutes.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SomeBusinessImplStubTest {

    @Test
    void findGreatestFromAll(){
        DataService dataServiceStub = new DataServiceStub1();
        SomeBusinessImpl businessImpl= new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25,result);
    }

    @Test
    void findGreatestFromAllWithOneValue(){
        DataService dataServiceStub = new DataServiceStub2();
        SomeBusinessImpl businessImpl= new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(35,result);
    }
}

class DataServiceStub1 implements DataService{
    @Override
    public int[] retrieveAllData(){
        return new int[]{25,15,5};
    }
}

class DataServiceStub2 implements DataService{
    @Override
    public int[] retrieveAllData(){
        return new int[]{35};
    }
}
