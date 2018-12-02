
t1.start();
t1.join();

Executors es = newSingleTheadExecutor();
es.submit(t1);
es.submit(t2);
es.submit(t3);