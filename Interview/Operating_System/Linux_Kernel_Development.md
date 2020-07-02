1. An application typically calls functions in a library—for example, the C 
   library—that in turn rely on the system call interface to instruct the kernel to carry out 
   tasks on the application’s behalf. 
   
2. When an application executes a system call, we say that the kernel is  
   executing on behalf of the application. Furthermore, the application is said to be executing a 
   system call in kernel-space, and the kernel is running in process context.
   
3. 