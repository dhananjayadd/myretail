package com.myretail.myretail;

import com.myretail.myretail.entity.TotalRewards;
import com.myretail.myretail.service.RewardsService;
import com.myretail.myretail.service.impl.RewardsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RewardsServiceImplTest {

    @Mock
    private RewardsServiceImpl rewardsServiceImpl;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        when(rewardsServiceImpl.getTotalRewardsByCustomer(111)).thenReturn(new TotalRewards(111,340));
    }

    @Test
   public void getTotalRewards(){
        TotalRewards rewards = rewardsServiceImpl.getTotalRewardsByCustomer(111);
        assertEquals(340, rewards.getTotalRewards());
        verify(rewardsServiceImpl, times(1)).getTotalRewardsByCustomer(111);
    }

}
