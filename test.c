#include<stdio.h>
int main()
{
int max(int x,int y,int z);
int a,b,c,d;
scanf("%d,%d,%d",&a,&b,&c);
d=max(a,b,c);
printf("max=%d\n",d);
}
int max(int x,int y,int z) {
 int h;
 if(x>y)h=x;
 else h=y;
 if(z>h)h=z;
 return(h);
}