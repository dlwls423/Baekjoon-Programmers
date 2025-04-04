#include <stdio.h>
#include <string.h>
int main(){
  int ascii[91]={0,};
  char c;
  while((c=getchar())!='\n'){
    int a;
    a=c;
    if(a>90) a-=32;
    ascii[a]++;
  }
  int max1, max2;
  if(ascii[65]>=ascii[66]){
    max1=65; max2=66;
  }
  else{
    max1=66; max2=65;
  }
  for(int i=67;i<91;i++){
    if(ascii[i]>=ascii[max1]){
      max2=max1;
      max1=i;
    }
    else if(ascii[i]>=ascii[max2]) max2=i;
  }

  if(ascii[max1]==ascii[max2]) printf("?");
  else printf("%c",max1);
  return 0;
}