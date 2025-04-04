#include <stdio.h>
#include <math.h>
int main(){
  int N, sum=1, num=1;
  scanf("%d",&N);
  while(N>sum){
    sum += num*6;
    num++;
  }
  printf("%d",num);
  return 0;
}