package assemble.repo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/13.
 */
public class ThreadPoolRepo {
    private static ThreadPoolRepo threadPoolRepo = new ThreadPoolRepo();

    public static ThreadPoolRepo getInstance() {
        return threadPoolRepo;
    }

    private ThreadPoolRepo() {
    }
    private int nThreads=Runtime.getRuntime().availableProcessors()*4;

    private ExecutorService executorService = new ThreadPoolExecutor(nThreads,nThreads,0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(800));
    public static ExecutorService newExecutorService(){
        return  threadPoolRepo.executorService;
    }
}
