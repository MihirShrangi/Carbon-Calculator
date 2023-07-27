 
function  result(){
   
    var score=0;
    // Question1
   if(document.getElementById('q1').checked){
        score=score+14;
    }else{
        if(document.getElementById('q2').checked){
        score=score+12;
    }else{
        if(document.getElementById('q3').checked){
        score=score+10;
    }
    score=score+2;
    }
    }
      // Question2
    if(document.getElementById('correct1').checked){
        score=score+3;
    }else{
        if(document.getElementById('correct2').checked){
        score=score+2;
    }else{
        if(document.getElementById('correct3').checked){
        score=score+1;
    }
    score=score+0;
    }
    }

     // Question3
    if(document.getElementById('que1').checked){
        score=score+12;
    }else{
        if(document.getElementById('que2').checked){
        score=score+10;
    }else{
        if(document.getElementById('que3').checked){
        score=score+6;
    }
    score=score+0;
    }
    }

     // Question4
     if(document.getElementById('Q1').checked){
        score=score+50;
    }else{
        if(document.getElementById('Q2').checked){
        score=score+30;
    }else{
        if(document.getElementById('Q3').checked){
        score=score+20;
    }
    score=score+5;
    }
    }

    // Question5
    if(document.getElementById('C1').checked){
        score=score+2;
    }else{
        if(document.getElementById('C2').checked){
        score=score+5;
    }else{
        if(document.getElementById('C3').checked){
        score=score+9;
    }
    score=score+12;
    }
    }
   // Question6   //Multiply your kilowatt hours by 0.994. For example, 67 hrs X 0.994 = 66.60 lbs of CO2.
   if(document.getElementById('F1').checked){
    score=score+(5 * 0.994);
    }else{
    if(document.getElementById('F2').checked){
    score=score+(10 * 0.994);
    }else{
    if(document.getElementById('F3').checked){
    score=score+(15 * 0.994);
    }
      score=score+(20 * 0.994);
    }
   }

   // Question7   // Multiply your natural gas usage (therms) by 11.7. For example, 19 therms X 11.7 = 222.3 lbs of CO2.
   if(document.getElementById('N1').checked){
    score=score+(5 * 11.7);
    }else{
    if(document.getElementById('N2').checked){
    score=score+(7 * 11.7);
    }else{
    if(document.getElementById('N3').checked){
    score=score+(9 * 11.7);
    }
      score=score+(10 * 11.7);
    }
   }
    
   //Question 8 
    if(document.getElementById('E1').checked){
        score=score+2;
    }else{
        if(document.getElementById('E2').checked){
        score=score+6;
    }else{
        
        score=score+20;
    }  
    }

     document.getElementById("myText").innerHTML = "Your carbon footprint is "+score +"kt";
     
    }

    
