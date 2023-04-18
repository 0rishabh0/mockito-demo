package com.in28minutes.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl businessImpl;

    @Test
    void findGreatestFromAll(){
//        DataService dataServiceMock = mock(DataService.class);
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25,15,5});
//        SomeBusinessImpl businessImpl= new SomeBusinessImpl(dataServiceMock);
        assertEquals(25, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    void findGreatestFromAllWithOneValue(){
//        DataService dataServiceMock =mock(DataService.class);
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});
//        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        assertEquals(35, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    void findGreatestFromAllWhenEmpty(){
//        DataService dataServiceMock =mock(DataService.class);
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
//        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }
}

