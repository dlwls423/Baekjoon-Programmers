#include <stdio.h>
int main(){
  int a, b, c, f=1;
  scanf("%d %d %d",&a ,&b ,&c);
  while(!(a==0&&b==0&&c==0)){
    if(a>=b&&a>=c){
      if(a>=b+c) {printf("Invalid\n"); f=0;}
    }
    else if(b>=a&&b>=c){
      if(b>=a+c) {printf("Invalid\n"); f=0;}
    }
    else if(c>=a&&c>=b){
      if(c>=a+b) {printf("Invalid\n"); f=0;}
    }
    
    if(f!=0){
      if(a==b&&b==c) printf("Equilateral\n");
      else if(a==b||b==c||a==c) printf("Isosceles\n");
      else printf("Scalene\n");
    }
    f=1;
    scanf("%d %d %d",&a ,&b ,&c);
  }
  
  return 0;
}