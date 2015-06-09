 $(document).ready(function(){

     var sigs = [];//信号机数组
     var canvas =document.getElementById("canvas");
     var  context =canvas.getContext("2d");
     var dots = [];//坐标点
     var dotsbak = [];//原坐标点

     setSigs();//设置信号机
     createDiv();//初始化div
     setDivs(sigs);//设置 信号机 div
     setSpeedDiv(sigs);//设置 速度

     setDots();//初始化坐标点  dots[]

     console.log(dots);

     dotsbak = dots.slice();//复制js数组

     for(var i=0;i<dots.length;i++)
     {
         setSigDraggable(i);//设置信号机拖动事件
         $("#sigtime"+i).css('margin-left',dots[i].x);
         $("#sigdistance"+i).css('margin-top',dots[i].y);
         $("#sigdistance"+i).text(dots[i].y);
     }


         drawLine();


         function setSigDraggable(index)
         {
             $("#sig"+index).draggable({axis:"x"});
             $( "#sig"+index ).on( "dragstop", function( event, ui ) {


                 context.clearRect(0,0,canvas.width,canvas.height);

                 console.log(" dots[index]"+ dots[index].x);



                 dots[index] =   new Dot(dotsbak[index].x+ui.offset.left-8,dots[index].y,"t0");



                 console.log(" dots[index]"+ dots[index].x);



                 $("#sigtime"+index).css('margin-left',dots[index].x);


                 if(index==0)
                 {
                     $("#sigspeed0").css('margin-left',(dots[index].x+dots[index+1].x)/2);
                     $("#sigspeed0").text((dots[index].y+dots[index].y)/(dots[index].x+dots[index+1].x));
                 }

                 if(index==1)
                 {

                     $("#sigspeed0").css('margin-left',(dots[index-1].x+dots[index].x)/2);
                     $("#sigspeed0").text((dots[index-1].y+dots[index].y)/(dots[index].x+dots[index-1].x));

                     $("#sigspeed"+index).css('margin-left',(dots[index].x+dots[index+1].x)/2);
                     $("#sigspeed"+index).text((dots[index].y+dots[index].y)/(dots[index].x+dots[index+1].x));
                 }


                 if(index==2)
                 {
                     var speedindex = index-1;
                     $("#sigspeed"+speedindex).css('margin-left',(dots[index-1].x+dots[index].x)/2);
                     $("#sigspeed"+speedindex).text((dots[index-1].y+dots[index].y)/(dots[index].x+dots[index-1].x));

                 }


                 if(index<2&&index>0)
                 {
                         console.log(dots[index-1].x);
                         console.log(dots[index].x);

                     console.log(dots[index+1].x);
                     if(dots[index].x>dots[index+1].x || dots[index].x<dots[index-1])
                     {
                         alert("操作错误,请返回");

                     }else
                     {

                         $("#sigtime"+index).text(dots[index].x);


                         $("#sigdistance"+index).css('margin-top',dots[index].y);
                         $("#sigdistance"+index).text(1000-dots[index].y);
                         drawLine() ;
                     }

                 }
                 else
                 {
                     if(index==0)
                     {
                         if(dots[index].x>=dots[index+1].x)
                         {
                             alert("操作错误,请返回");
                         }else
                         {
                             $("#sigtime"+index).text(dots[index].x);


                             $("#sigdistance"+index).css('margin-top',dots[index].y);
                             $("#sigdistance"+index).text(1000-dots[index].y);
                             drawLine() ;
                         }
                     }
                     if(index==2)
                     {
                         if(dots[index].x<=dots[index-1])
                         {
                             alert("操作错误,请返回");
                         }else
                         {
                             $("#sigtime"+index).text(dots[index].x);


                             $("#sigdistance"+index).css('margin-top',dots[index].y);
                             $("#sigdistance"+index).text(1000-dots[index].y);
                             drawLine() ;
                         }
                     }

                 }

             } );

         }

         function drawLine()
         {
             if(dots.length>1)
             {
                 for(var i=0;i<dots.length-1;i++)
                 {
                     context.beginPath();
                     context.moveTo(dots[i].x,dots[i].y);
                     context.lineTo(dots[i+1].x,dots[i+1].y);
                     context.stroke();
                 }
             }
         }

     /**
      * 根据信号机对象的位置，设置点坐标
      * 正向
      * 默认 周期a 相位0 开始
      * # a 0 0  a-信号机周期   0-信号机编号 0-相位编号
      *
      * 反向
      * 默认周期a开始
      * # a 0 4  a-信号机周期   0-信号机编号 4-相位编号(末尾)
      *
      */

         function setDots()
         {
             //正向坐标点
             for(var i=0;i<sigs.length;i++)
             {

                 var dot = new Dot($("#"+sigs[i].zhengxiang).offset().left-8,$("#"+sigs[i].zhengxiang).offset().top-8,"t0");
                 dots.push(dot);

             }

             //反向坐标点
             for(var i=0;i<sigs.length;i++)
             {
                 var dot = new Dot($("#"+sigs[i].fanxiang).offset().left-8,$("#"+sigs[i].fanxiang).offset().top-8,"t0");
                 dots.push(dot);

             }



         }

         //用于画线点对象构造方法
         function Dot(x,y,name)
         {
             this.x = x;
             this.y = y;
             this.name  = name;
         }

         //信号机 开始时间和长度构造方法
         function Sig(time,distance,phasenum,zhengxiang,fanxiang)
         {
             this.time = time;
             this.distance = distance;
             this.phasenum = phasenum;
             this.zhengxiang = zhengxiang;// a 0 0 : 周期 信号机编号 相位
             this.fanxiang = fanxiang;// b 0 0 : 周期 信号机编号 相位
         }


         function setSigs()
         {
             var sig1 = new Sig(38,128,[0.33,0.33,0.33],"a00","b02");
             sigs.push(sig1);
             var sig2 = new Sig(68,182,[0.25,0.25,0.25,0.25],"a10","b11");
             sigs.push(sig2);
             var sig3 = new Sig(98,282,[0.166,0.166,0.166,0.166,0.166,0.166],"a20","a25");
             sigs.push(sig3);
         }

     //构建sig div
      function createDiv()
      {

         console.log("------------------createDiv----------");
          for(var i=0;i<sigs.length;i++)
          {

              var sigdiv=$('<div>'+'sig'+i+'</div>');             //创建一个父div
              var sigtimediv=$('<div></div>');
              var sigdistance=$('<div></div>');

              sigdiv.addClass('initsig');
              sigtimediv.addClass('initsigtime');
              sigdistance.addClass('initsigdistance');

              sigdiv.attr('id','sig'+i);
              sigtimediv.attr('id','sigtime'+i);
              sigdistance.attr('id','sigdistance'+i);
              // parentdiv.attr('id','parent');           //给父div设置id
              //  sigdiv.addclass('initsig');         //添加css样式



              //相位周期div
             for(var j=0;j<sigs[i].phasenum.length;j++)
             {
                 var tdiv=$('<div>'+'t'+j+'</div>');            //创建一个子div
                 tdiv.addClass("initsigt");
                 tdiv.attr('id','a'+i+j);//给子div设置id
                 //childdiv.addclass('childdiv');          //添加css样式
                 tdiv.appendTo(sigdiv);            //将子div添加到父div中
             }

              //相位周期div
              for(var j=0;j<sigs[i].phasenum.length;j++)
              {
                  var tdiv=$('<div>'+'t'+j+'</div>');            //创建一个子div
                  tdiv.addClass("initsigt");
                  tdiv.attr('id','b'+i+j);//给子div设置id
                  //childdiv.addclass('childdiv');          //添加css样式
                  tdiv.appendTo(sigdiv);            //将子div添加到父div中
              }

              sigdiv.appendTo($("#topdiv"));              //将父div添加到body中
              sigtimediv.appendTo($("#topdiv"));
              sigdistance.appendTo($("#topdiv"));
          }

         //速度div
          for(var i=0;i<sigs.length-1;i++)
          {
              var sigspeed =  $('<div></div>');
              sigspeed.addClass('initsigspeed');
              sigspeed.attr('id','sigspeed'+i);//给子div设置id
              sigspeed.appendTo($("#topdiv"));
          }

      }

     //设置div
     function setDivs(sigs)
     {
         for(var i=0;i<sigs.length;i++)
         {
             $("#sig"+i).css("margin-top",1000-sigs[i].distance);
             $("#sig"+i).css("margin-left",sigs[i].time);
             $("#sigdistance"+i).css("margin-top",1000-sigs[i].distance);
             $("#sigtime"+i).css("margin-left",sigs[i].time);


             for(var j=0;j<sigs[i].phasenum.length;j++)
             {
                 var phasewidth = sigs[i].phasenum[j]*500;
                 if(j%2==0)
                 {
                     $("#a"+i+j).css("background","#07FCE5");

                     $("#a"+i+j).css("width",phasewidth);

                     $("#b"+i+j).css("background","#07FCE5");
                     $("#b"+i+j).css("width",phasewidth);

                 }else
                 {
                     $("#a"+i+j).css("width",phasewidth);

                     $("#b"+i+j).css("width",phasewidth);
                 }

             }
           //  console.log($("#sig"+i).css());
         }

     }

     function setSpeedDiv(sigs)
     {
         for(var i=0;i<2;i++)
         {
             var mtop = (1000-sigs[i].distance+ 1000-sigs[i+1].distance)/2;
             var mleft = (sigs[i].time+sigs[i+1].time)/2;
             console.log(mtop,mleft);
             $("#sigspeed"+i).css("margin-top", mtop);
             $("#sigspeed"+i).css("margin-left",mleft);
             $("#sigspeed"+i).text(mtop/mleft);
         }
     }

        });