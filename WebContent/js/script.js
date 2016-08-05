UI = {
  isLower:false,
  logobusy: false,
  logocollapsed: false,
  lastScrollTop: false,
  init: function() {
    if (document.getElementById('header_date')) {
      var options = {
        weekday: "long",
        year: "numeric",
        month: "long",
        day: "numeric"
      };
      var d = new Date().toLocaleDateString('en',options);
      if (d.split(' ').length <= 3) {
        var weekday = new Date().toString();
        weekday = weekday.split(' ');
        weekday = weekday[0] + ', ';
        d = weekday + d;
      }
      document.getElementById('header_date').innerHTML = d;
    }
    if (document.getElementById('header_time')) {
      setInterval(function(){
        var t = new Date().toLocaleTimeString();
        var tpieces = t.split(' ');
        var tfrag = tpieces[0].split(':');
        var tdisplay = tfrag[0]+':'+tfrag[1]+' '+tpieces[1];
        document.getElementById('header_time').innerHTML = tdisplay;
      },1000);
    }
  },
  collapseLogo: function() {
    if (!this.logobusy) {
      this.logocollapsed = true;
      this.logobusy = true;
      var header = document.getElementById('header');
      if (header) {
        //header.className = 'header minimize';
        $(".header").removeClass('maximize');
        $(".header").addClass('minimize');
        $(".header").removeClass('height100px');
        $(".header").addClass('height64px');
//        $("#sidebar-wrapper").removeClass('marginTop100px');
//        $("#sidebar-wrapper").addClass('marginTop64px');
        $("#left-side").removeClass('top20px');
        $("#left-side").addClass('top7px');
        $("#right-side").removeClass('top20px');
        $("#right-side").addClass('top7px');
         // $("#page-content-wrapper").css("padding-top", "60px");
       }
       setTimeout(function(){
        for (i = 1; i <= 4; i++) { 
          var piece = document.getElementById('logo'+i);
          if (piece && piece.className != 'piece hidden2') {
            piece.className = 'piece hidden2';
          }
        }
        $(".moto").fadeOut(500);
      },10);
       var self = this;
       setTimeout(function(){
        self.logobusy = false;
      },500);
     }
   },
   expandLogo: function() {
    if (!this.logobusy && !this.isLower) {
      this.logocollapsed = false;
      this.logobusy = true;
      var header = document.getElementById('header');
      if (header) {
          //header.className = 'header maximize';
          $(".header").removeClass('minimize');
          $(".header").addClass('maximize');
          $(".header").removeClass('height64px');
          $(".header").addClass('height100px');
//          $("#sidebar-wrapper").removeClass('marginTop64px');
//          $("#sidebar-wrapper").addClass('marginTop100px');
          $("#left-side").removeClass('top7px');
          $("#left-side").addClass('top20px');
          $("#right-side").removeClass('top7px');
          $("#right-side").addClass('top20px');
          //$("#page-content-wrapper").css("padding-top", "90px");
        }
        var accountdropdown = document.getElementById('accountdropdown');
        if (accountdropdown) {
          accountdropdown.className = 'maximize';
        }
        setTimeout(function(){
          for (i = 1; i <= 4; i++) { 
            var piece = document.getElementById('logo'+i);
            if (piece && piece.className != 'piece visible') {
              piece.className = 'piece visible';
            }
          }
          $(".moto").fadeIn(500);
        },10);
        var self = this;
        setTimeout(function(){
          self.logobusy = false;
        },500);
      }
    }
  }

  $(window).load(function() {
      
    if($(window).width()<767){
        $("#facebook-text").html("");
        $("#twitter-text").html("");
        $("#google-text").html("");
    }else{

      
      $("#facebook-text").html("Facebook");
      $("#twitter-text").html("Twitter");
      $("#google-text").html("Google");
      
    }  
    
    if($(window).width()>600){
//      console.log("Show");
      UI.expandLogo();
      
      // UI.isLower = true;
      // $("#wrapper").toggleClass("toggled");
      // $(".moto").hide();
      // $(".header").addClass('notransition'); // Disable transitions
      // $(".id").addClass('notransition'); // Disable transitions
      // $("#left-side").addClass('notransition'); // Disable transitions
      // $("#right-side").addClass('notransition'); // Disable transitions
      // $(".sidebar-wrapper").addClass('notransition'); // Disable transitions
      // for (i = 1; i <= 4; i++) { 
      //     $('#logo'+i).addClass('notransition');
      //   }
      // UI.collapseLogo();
      // $(".header").removeClass('notransition'); // Disable transitions
      // $(".id").removeClass('notransition'); // Disable transitions
      // $("#left-side").removeClass('notransition'); // Disable transitions
      // $("#right-side").removeClass('notransition'); // Disable transitions
      // $(".sidebar-wrapper").removeClass('notransition'); // Disable transitions
      // for (i = 1; i <= 4; i++) { 
      //     $('#logo'+i).removeClass('notransition');
      //   }

    }else{
      UI.isLower = true;

    }
  });


$(window).resize(function() {
  var windowsize = $(window).width();

  if(windowsize<767){
    UI.isLower = true;
    UI.collapseLogo();
    
      $("#twitter-text").html("");
      $("#facebook-text").html("");
      $("#google-text").html("");
      
    }else{
      $("#facebook-text").html("Facebook");
      $("#twitter-text").html("Twitter");
      $("#google-text").html("Google");
    }
    

    
  if(windowsize<600){
    UI.isLower = true;
    UI.collapseLogo();
      
    }else{
        UI.isLower=false;
        var scrollTop = window.pageYOffset;
        if (scrollTop < 50 && UI.logocollapsed || scrollTop == 0) {
          UI.expandLogo();
        }
       
      }
    
});


window.addEventListener('scroll', function () {
  var scrollTop = window.pageYOffset;
  if (scrollTop > 0 && !UI.logocollapsed && scrollTop > UI.lastScrollTop) {
    UI.collapseLogo();
  }
  else if (scrollTop < UI.lastScrollTop - 1 && scrollTop < 50 && UI.logocollapsed || scrollTop == 0) {
    UI.expandLogo();
  }
  UI.lastScrollTop = scrollTop;
});
$(window).scroll(function(){
  $('#header').css('left',-$(this).scrollLeft()/2);
});
$("#menu-toggle").mouseup(function(){
  $(this).blur();
})

$(".align-button-left").click(function(){
  if($('.post-options').is(':visible')) {
    $('.post-options').hide(500);
  }
  else {
    $('.post-options').show(500);
  }
});

function checkLength(){
   
  var taggle_sizer = document.getElementsByClassName("taggle_sizer")[0];
    
  var textArea = document.getElementsByClassName("tags")[0];
    
  var taggle_input = document.getElementsByClassName("taggle_input")[0];
    
    taggle_input.setAttribute("maxlength","19");
    
    var isActive = textArea.classList.contains("active");
    
  if(taggle_sizer.textContent.length > 19 && isActive == true)
     {
       var str = taggle_sizer.textContent.substring(0,19); document.getElementsByClassName("taggle_sizer")[0].innerHTML = str;
taggle_input.innerHTML = str;

         
    }
  copyToInputHidden();
}

function copyToInputHidden(){
	var tags = document.getElementsByClassName("taggle_text");
	var inputTags = $(".tagsInput");
	
	if(tags.length != 0){
	var first = tags[0].innerHTML;
	var tagsToCopy = first;
	
	for(var i=1;i<tags.length; i++) {
		var textTag = tags[i].innerHTML;
		
		tagsToCopy = tagsToCopy + "|" + textTag;
		
	}
	
		document.getElementById("newThreadForm:tagsInput").value = tagsToCopy;
	}
}


$(document).mouseup(function (e)
{ 
  if(e.which == 1){//left
    var container = $("#menu-toggle");
    var c2 = $(".post-options");
    if (!container.is(e.target) // if the target of the click isn't the container...
      && container.has(e.target).length === 0 &&
        !c2.is(e.target)  // if the target of the click isn't the container...
        && c2.has(e.target).length === 0 ) // ... nor a descendant of the container
    {
      $('.post-options').hide(500);
    }
  }
});

function isHidden(el) {
    return (el.offsetParent === null)
}

$("#overview").click(function() {
  if($("#overview-body").is(":visible")){
     $("#overview-body").hide("fast");
     $("#arrow-overview-icon").removeClass("glyphicon-chevron-up");
     $("#arrow-overview-icon").addClass("glyphicon-chevron-down");
      
  }
  else {
    $("#overview-body").show("fast"); 
    $("#arrow-overview-icon").removeClass("glyphicon-chevron-down");
    $("#arrow-overview-icon").addClass("glyphicon-chevron-up");
  }
});

$("#connected-accounts").click(function() {
  if($("#connected-accounts-body").is(":visible")){
     $("#connected-accounts-body").hide("fast");
     $("#arrow-connected-icon").removeClass("glyphicon-chevron-up");
     $("#arrow-connected-icon").addClass("glyphicon-chevron-down");
      
  }
  else {
    $("#connected-accounts-body").show("fast");    
    $("#arrow-connected-icon").removeClass("glyphicon-chevron-down");
    $("#arrow-connected-icon").addClass("glyphicon-chevron-up");
  }
});

$("#saved-threads").click(function() {
  if($("#saved-threads-body").is(":visible")){
     $("#saved-threads-body").hide("fast");
     $("#arrow-saved-icon").removeClass("glyphicon-chevron-up");
     $("#arrow-saved-icon").addClass("glyphicon-chevron-down");
  }
  else {
    $("#saved-threads-body").show("fast");  
    $("#arrow-saved-icon").removeClass("glyphicon-chevron-down");
    $("#arrow-saved-icon").addClass("glyphicon-chevron-up");
  }
});

$(function(){
	document.getElementById("newThreadForm:newThreadTitle").placeholder = "Give it a title";	
});
