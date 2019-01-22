var flag=0;
    $("#i1").click(function () {
        $("#bigImage").show();
        $("#bigImage img").attr('src', '1.jpg');
       flag=1;
    });
    $("#i2").click(function () {
        $("#bigImage").show();
        $("#bigImage img").attr('src', '2.jpg');
        flag=2;
    });
    $("#i3").click(function () {
        $("#bigImage").show();
        $("#bigImage img").attr('src', '3.jpg');
        flag=3;
    });
    $("#i4").click(function () {
        $("#bigImage").show();
        $("#bigImage img").attr('src', '4.jpg');
        flag=4;
    });
    $("#i5").click(function () {
        $("#bigImage").show();
        $("#bigImage img").attr('src', '5.jpg');
        flag=5;
    });
    $("#i6").click(function () {
        $("#bigImage").show();
        $("#bigImage img").attr('src', '6.jpg');
        flag=6;
    });
$("#i7").click(function () {
        $("#bigImage").show();
        $("#bigImage img").attr('src', '7.jpg');
        flag=7;
    });
$("#i8").click(function () {
        $("#bigImage").show();
        $("#bigImage img").attr('src', '8.jpg');
        flag=8;
    });
$("#i9").click(function () {
        $("#bigImage").show();
        $("#bigImage img").attr('src', '9.jpg');
        flag=9;
    });

    $("#close").click(function () {
        $("#bigImage").hide();
    });
    $("#next").click(function () {
        if(flag==1){
            $("#bigImage img").attr('src', '2.jpg');
            flag=2;
        }else
        if(flag==2){
            $("#bigImage img").attr('src', '3.jpg');
            flag=3;
        }else
        if(flag==3){
            $("#bigImage img").attr('src', '4.jpg');
            flag=4;
        }else
        if(flag==4){
            $("#bigImage img").attr('src', '5.jpg');
            flag=5;
        }else
        if(flag==5){
            $("#bigImage img").attr('src', '6.jpg');
            flag=6;
        }
        else
        if(flag==6){
            $("#bigImage img").attr('src', '7.jpg');
            flag=7;
        }
        else
        if(flag==7){
            $("#bigImage img").attr('src', '8.jpg');
            flag=8;
        }else
        if(flag==8){
            $("#bigImage img").attr('src', '9.jpg');
            flag=9;
        }
        else
        if(flag==9){
            $("#bigImage img").attr('src', '1.jpg');
            flag=1;
        }
    });
$("#pre").click(function () {
    if(flag==1){
        $("#bigImage img").attr('src', '9.jpg');
        flag=9;
    }else
    if(flag==2){
        $("#bigImage img").attr('src', '1.jpg');
        flag=1;
    }else
    if(flag==3){
        $("#bigImage img").attr('src', '2.jpg');
        flag=2;
    }else
    if(flag==4){
        $("#bigImage img").attr('src', '3.jpg');
        flag=3;
    }else
    if(flag==5){
        $("#bigImage img").attr('src', '4.jpg');
        flag=4;
    }else
    if(flag==6){
        $("#bigImage img").attr('src', '5.jpg');
        flag=5;
    }
    else
    if(flag==7){
        $("#bigImage img").attr('src', '6.jpg');
        flag=6;
    }else
    if(flag==8){
        $("#bigImage img").attr('src', '7.jpg');
        flag=7;
    }else
    if(flag==9){
        $("#bigImage img").attr('src', '8.jpg');
        flag=8;
    }
});
