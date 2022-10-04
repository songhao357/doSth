package com.songhao.demo.current;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.LinkedList;
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
         if(!CollectionUtils.isEmpty(runnableList)){
             runnableList.forEach(runnable -> executor.execute(runnable));
         }
     }

     public  List executeCallList(){
         if(!CollectionUtils.isEmpty(callableList)){
             List results = new LinkedList();
             callableList.forEach(callable ->
                     results.add(executor.submit(callable))
             );
             return results;
         }
         return Collections.emptyList();
     }

     public  List executeFutureTasks(){
         if(!CollectionUtils.isEmpty(futureTaskList)){
             List results = new LinkedList();
             futureTaskList.forEach(futureTask ->
                     results.add(executor.submit(futureTask))
             );
             return results;
         }
         return Collections.emptyList();
     }




    @Override
    public void afterPropertiesSet() throws Exception {
        executor =new ThreadPoolExecutor(4,20,10000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1024),new ThreadPoolExecutor.AbortPolicy());
    }
}
