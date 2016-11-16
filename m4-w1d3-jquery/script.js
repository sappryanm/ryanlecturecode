/// <reference path="jquery-2.1.0-vsdoc.js" />

$(document).ready(function () {

    //1. Get an HTML element by id
    var box1 = $("#box1");    
    console.log(box1);
        
    //2. Get an HTML element by class name
    var redBoxes = $(".red");
    console.log(redBoxes);

    //3. Get HTML elements by tag name
    var divBoxes = $("div");
    console.log(divBoxes);   

    //4. Filter out the boxes for odd-numbered ones
    var oddNumberedBoxes = $("div").filter(":odd");
    console.log(oddNumberedBoxes);

    //5. Get Specaial List Items
    var specialItems = $("li").filter(".special");
    console.log(specialItems);
    //OR
    var specialItems2 = $("li.special");
    console.log(specialItems2);
   
    //6. Get the last box
    var lastH2 = $("div.box").last();
    console.log(lastH2);

    //7. Get the parent box of boring text
    var parent = $(".boring").parent();
    console.log(parent);

    //8. Get the box after the blue-one
    var boxAfterList = $("div.blue").next();
    console.log(boxAfterList);

    //9. Get all children inside the grey box except <br/>
    var greyBoxChildren = $(".grey").children().not("br");
    console.log(greyBoxChildren);

    //10. Get the value of the text box
    var textBoxValue = $("#nameField").val();
    console.log(textBoxValue);

    //11. Set the value of the text box to Tech Elevator
    $("#nameField").val("Tech Elevator");
    
    //12. Get the value of the first <p> tag in the green box
    var greenBoxPTag = $(".green").children("p")    
    console.log("Before " + greenBoxPTag.html());

    //13. Change the html to something better
    greenBoxPTag.html("<b>there this is better</b>");

    //14. Change all of the li tags to something better
    $("li").text("hacked");

    //15. Change the link attribute in the green box
    $(".green").children("a").attr("href", "http://www.techelevator.com");

    //16. Check the boxes in the grey box    
    $(".grey").children(":checkbox").attr("checked", "checked");

    //17. Make all of the other boxes grey and the black box red
    var blackBox = $(".grey");
    var otherBoxes = $(".box").not(".grey");        
    //blackBox.removeClass("grey").addClass("red");
    //otherBoxes.removeClass().addClass("box").addClass("black");
    
    //18. Add a new list item
    $("ul").append("<li>Item 6</li>")

    //19. Move the even numbered items from the yellow box to the green box
    var list = $("li").filter(":even").detach();
    $(".green").children().filter("ol").append(list);
    

});