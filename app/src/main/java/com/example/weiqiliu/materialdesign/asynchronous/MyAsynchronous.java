package com.example.weiqiliu.materialdesign.asynchronous;


import android.os.AsyncTask;

public class MyAsynchronous extends AsyncTask<String, Integer, String> {
    //这个方法是在执行异步任务之前的时候执行，并且是在UI Thread当中执行的，
    // 通常我们在这个方法里做一些UI控件的初始化的操作，例如弹出要给ProgressDialog
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    // 在onPreExecute()方法执行完之后，会马上执行这个方法，
    // 这个方法就是来处理异步任务的方法，Android操作系统会在后台的线程池当中开启一个
    // worker thread来执行我们的这个方法，所以这个方法是在worker thread当中执行的，
    // 这个方法执行完之后就可以将我们的执行结果发送给我们的最后一个 onPostExecute 方法，
    // 在这个方法里，我们可以从网络当中获取数据等一些耗时的操作
    @Override
    protected String doInBackground(String... params) {
        return null;
    }

    //这个方法也是在UI Thread当中执行的，我们在异步任务执行的时候，
    // 有时候需要将执行的进度返回给我们的UI界面，例如下载一张网络图片，
    // 我们需要时刻显示其下载的进度，就可以使用这个方法来更新我们的进度。
    // 这个方法在调用之前，我们需要在 doInBackground 方法中调用一个 publishProgress(Progress)
    // 的方法来将我们的进度时时刻刻传递给 onProgressUpdate 方法来更新
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    //当我们的异步任务执行完之后，就会将结果返回给这个方法，
    // 这个方法也是在UI Thread当中调用的，我们可以将返回的结果显示在UI控件上
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
