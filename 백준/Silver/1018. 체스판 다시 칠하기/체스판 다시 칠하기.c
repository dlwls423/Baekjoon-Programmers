#include <stdio.h>
int main(){
  int M, N, min=250, f=0, sum;
  char chess[50][50]={0,};
  scanf("%d %d",&M ,&N);
  for(int i=0;i<M;i++){
      scanf("%s",chess[i]);
  }
  for(int i=0;i<=M-8;i++){
    for(int j=0;j<=N-8;j++){
      sum=0;
      for(int x=i;x<i+8;x++){
        for(int y=j;y<j+8;y++){
          if(f==0){
            if(((x+y)%2==0)&&(chess[x][y]!='W')) sum++;
            else if(((x+y)%2==1)&&(chess[x][y]!='B')) sum++;
          }
          else{
            if(((x+y)%2==0)&&(chess[x][y]!='B')) sum++;
            else if(((x+y)%2==1)&&(chess[x][y]!='W')) sum++;
          }
        }
      }
      if(min>sum) min = sum;
      if(f==0) {j--; f=1;}
      else f=0;
    }
  }
  printf("%d",min);
  
  return 0;
}