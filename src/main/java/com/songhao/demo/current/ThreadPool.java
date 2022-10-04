package com.songhao.demo.current;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.*;

@Component
@Getter
@Setter
public class ThreadPool implements InitializingBean {

     private ThreadPoolExecutor executor;

     private List<Runnable> runnableList;

     private List<Callable> callableList;

     private List<FutureTask> futureTaskList;



     public void execute(Runnable r){
         executor.execute(r);
     }

     public void executeRunList(){
         runnableList.forEach(runnable -> executor.execute(runnable));
     }
     public void executeCallList(){
         callableList.forEach(callable -> executor.submit(callable) );
     }




    @Override
    public void afterPropertiesSet() throws Exception {
        executor =new ThreadPoolExecutor(4,1024,10000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1024),new ThreadPoolExecutor.AbortPolicy());
    }
}
