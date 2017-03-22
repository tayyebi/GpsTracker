jQuery.fn.foxholder = function(number) {
  this.addClass("form-container").attr("id", "example-"+number.demo);

  //adding labels with placeholders content. Removing placeholders
  this.find('form').find('input,textarea').each(function() {
    var placeholderText, formItemId, inputType; 

    //wrapping form elements in their oun <div> tags
    jQuery(this).wrap('<div class="form-item-block"></div>'); 

    //creating labels
    inputType = jQuery(this).attr('type');

    if (inputType == 'hidden') {

    } else {
      placeholderText = jQuery(this).attr('placeholder');
      formItemId = jQuery(this).attr('id')
      jQuery(this).after('<label for="'+ formItemId +'"><span>'+ placeholderText +'</span></label>');
      jQuery(this).removeAttr('placeholder');
    }
  });

  //adding class on blur
  jQuery('.form-container form').find('input,textarea').blur(function(){
    if (jQuery.trim(jQuery(this).val())!="") {
      jQuery(this).addClass("active");
    } else {
      jQuery(this).removeClass("active");
    }
  });

  //adding line-height for block with textarea 
  jQuery('.form-item-block').each(function() {
    if (jQuery(this).has('textarea').length > 0) {
      jQuery(this).css({'line-height': '0px'});
    }
  });


  //examples scripts

  if (number.demo == 2) {

    //example-2 adding top property for label
    jQuery('#example-2 input, #example-2 textarea').focus(function() {
      var labelTop;
      labelTop = parseInt(jQuery(this).css('padding-top'));
      jQuery(this).next('label').css({'top': 0 - (labelTop + 6)});
      console.log(labelTop);
    });

    jQuery('#example-2 input, #example-2 textarea').blur(function() {
      if (jQuery(this).hasClass('active')) {
      } else {
        jQuery(this).next('label').css({'top': 0});
      }
    });
  }

  if (number.demo == 3) {

    //example-3 paddings for inputs
    jQuery('#example-3 input').focus(function() {
      var labelWidth;
      labelWidth = jQuery(this).siblings('label').width() + 36;
      jQuery(this).css({'padding-left': labelWidth});
    });

    jQuery('#example-3 input').blur(function() {
      if (jQuery(this).hasClass('active')) {
      } else {
        jQuery(this).css({'padding-left': 20});
      }
    });

    //example-3 paddings for textarea
    jQuery('#example-3 textarea').focus(function() {
      var labelWidth;
      labelWidth = jQuery(this).siblings('label').height() + 41;
      jQuery(this).css({'padding-top': labelWidth});
    });

    jQuery('#example-3 textarea').blur(function() {
      if (jQuery(this).hasClass('active')) {
      } else {
        jQuery(this).css({'padding-top': 20});
      }
    });

  }

  if (number.demo == 4) {

    //example-4 moving to the left
    jQuery('#example-4 input, #example-4 textarea').focus(function() {

      var labelWidth;
      labelWidth = jQuery(this).next('label').width();
      console.log(labelWidth);
      jQuery(this).next('label').css({'left': 0 - (labelWidth + 60)});
    });

    jQuery('#example-4 input, #example-4 textarea').blur(function() {
      if (jQuery(this).hasClass('active')) {
      } else {
        jQuery(this).next('label').css({'left': 1});
      }
    });

  }

  if (number.demo == 7) {

    //example-7 adding icon
    jQuery('#example-7 input, #example-7 textarea').each(function() {
      jQuery(this).parent().append('<div class="icon-triangle"></div>');
    });

    jQuery('#example-7 input').each(function() {

      var inputHeight = jQuery(this).outerHeight();
      console.log(inputHeight);

      jQuery(this).siblings('.icon-triangle').css({
        'border-width': inputHeight / 2,
        'border-left-width': 24
      })
    });

  }

  if (number.demo == 9) {

    //example-9 adding background
    jQuery('#example-9 input, #example-9 textarea').each(function() {
      jQuery(this).parent().append('<div class="overlay"></div>');

      var labelWidth, labelHeight;
      labelWidth = jQuery(this).siblings('label').width();
      labelHeight = jQuery(this).siblings('label').height();

      if (jQuery(this).is('input')) {
        jQuery(this).siblings('.overlay').css({
          'width': labelWidth,
          'height': '100%',
          'left': 0 - (labelWidth + 40),
        });
      } else {
        jQuery(this).siblings('.overlay').css({
          'width': labelWidth, 
          'height' : labelHeight + 40,
          'left': 0 - (labelWidth + 40),
        });
      }

      jQuery(this).focus(function() {
        jQuery(this).css({'padding-left': labelWidth + 36});
      });

      jQuery(this).blur(function() {
        if (!jQuery(this).hasClass('active')) {
          jQuery(this).css({'padding-left': 20});
        }
      });
    });

  }

  if (number.demo == 10) {

    //example-10 label top position
    jQuery('#example-10 input, #example-10 textarea').focus(function() {
      var labelTop;
      labelTop = parseInt(jQuery(this).css('padding-top'));
      jQuery(this).next('label').css({'top': 0 - (labelTop + 10)});
      console.log(labelTop);
    });

    jQuery('#example-10 input, #example-10 textarea').blur(function() {
      if (jQuery(this).hasClass('active')) {
      } else {
        jQuery(this).next('label').css({'top': 0});
      }
    });

  }

  if (number.demo == 11) {

    //example-11 adding borders
    jQuery('#example-11 .form-item-block').each(function() {
      jQuery(this).append('<div class="top-line"></div>').append('<div class="bottom-line"></div>').append('<div class="left-line"></div>').append('<div class="right-line"></div>');
    });

  }

  if (number.demo == 12) {

    //example-12 adding icon
    jQuery('#example-12 input, #example-12 textarea').each(function() {
      jQuery(this).parent().append('<div class="icon"></div>');
    });

  }

  if (number.demo == 13) {

    //example-13 elements padding
    jQuery('#example-13 input, #example-13 textarea').focus(function() {
      var labelWidth;
      labelWidth = jQuery(this).siblings('label').width() + 66;
      jQuery(this).css({'padding-left': labelWidth});
    });

    jQuery('#example-13 input, #example-13 textarea').blur(function() {
      if (jQuery(this).hasClass('active')) {
      } else {
        jQuery(this).css({'padding-left': 20});
      }
    });

  }

  if (number.demo == 14) {

    //example-14 adding borders
    jQuery('#example-14 .form-item-block').each(function() {
      jQuery(this).append('<div class="top-line"></div>').append('<div class="left-line"></div>').append('<div class="right-line"></div>');
    });

    //example-14 elements padding
    jQuery('#example-14 input, #example-14 textarea').focus(function() {
      var labelWidth;
      labelWidth = jQuery(this).siblings('label').width() + 66;
      jQuery(this).css({'padding-left': labelWidth});
    });

    jQuery('#example-14 input, #example-14 textarea').blur(function() {
      if (jQuery(this).hasClass('active')) {
      } else {
        jQuery(this).css({'padding-left': 20});
      }
    });    

  }


  if (number.demo == 15) {

    //example-15 adding triangle icons
    jQuery('#example-15 input, #example-15 textarea').each(function() {
      jQuery(this).next('label').append('<div class="top-triangle"></div>').append('<div class="bottom-triangle"></div>');
    });

    //example-15 elements padding
    jQuery('#example-15 input, #example-15 textarea').focus(function() {
      var labelWidth;
      labelWidth = jQuery(this).siblings('label').width() + 86;
      jQuery(this).css({'padding-left': labelWidth});
    });

    jQuery('#example-15 input, #example-15 textarea').blur(function() {
      if (jQuery(this).hasClass('active')) {
      } else {
        jQuery(this).css({'padding-left': 20});
      }
    });
    
  }

}
