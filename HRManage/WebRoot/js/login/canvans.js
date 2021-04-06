$(document).ready(function() {			
	var canvas = document.getElementById("c");
	var ctx = canvas.getContext("2d");
	var c = $("#c");
	var w,h;
	var pi = Math.PI;
	var all_attribute = {
		num:100,            			 // ����
		start_probability:0.1,		     // �������С��num������Щ�������һ���µ�     		     
		radius_min:1,   			     // ��ʼ�뾶��Сֵ
		radius_max:2,   			     // ��ʼ�뾶���ֵ
		radius_add_min:.3,               // �뾶������Сֵ
		radius_add_max:.5,               // �뾶�������ֵ
		opacity_min:0.3,                 // ��ʼ͸������Сֵ
		opacity_max:0.5, 				 // ��ʼ͸�������ֵ
		opacity_prev_min:.003,            // ͸���ȵݼ�ֵ��Сֵ
		opacity_prev_max:.005,            // ͸���ȵݼ�ֵ���ֵ
		light_min:40,                 // ��ɫ������Сֵ
		light_max:70,                 // ��ɫ�������ֵ
	};
	var style_color = find_random(0,360);  
	var all_element =[];
	window_resize();
	function start(){
		window.requestAnimationFrame(start);
		style_color+=.1;
		ctx.fillStyle = 'hsl('+style_color+',100%,97%)';
		ctx.fillRect(0, 0, w, h);
		if (all_element.length < all_attribute.num && Math.random() < all_attribute.start_probability){
			all_element.push(new ready_run);
		}
		all_element.map(function(line) {
			line.to_step();
		})
	}
	function ready_run(){
		this.to_reset();
	}
	ready_run.prototype = {
		to_reset:function(){
			var t = this;
			t.x = find_random(0,w);
			t.y = find_random(0,h);
			t.radius = find_random(all_attribute.radius_min,all_attribute.radius_max);
			t.radius_change = find_random(all_attribute.radius_add_min,all_attribute.radius_add_max);
			t.opacity = find_random(all_attribute.opacity_min,all_attribute.opacity_max);
			t.opacity_change = find_random(all_attribute.opacity_prev_min,all_attribute.opacity_prev_max);
			t.light = find_random(all_attribute.light_min,all_attribute.light_max);
			t.color = 'hsl('+style_color+',100%,'+t.light+'%)';
		},
		to_step:function(){
			var t = this;
			t.opacity -= t.opacity_change;
			t.radius += t.radius_change;
			if(t.opacity <= 0){
				t.to_reset();
				return false;
			}
			ctx.fillStyle = t.color;
			ctx.globalAlpha = t.opacity;
			ctx.beginPath();
			ctx.arc(t.x,t.y,t.radius,0,2*pi,true);
			ctx.closePath();
			ctx.fill();
			ctx.globalAlpha = 1;
		}
	}
	function window_resize(){
		w = window.innerWidth;
		h = window.innerHeight;
		canvas.width = w;
		canvas.height = h;
	}
	$(window).resize(function(){
		window_resize();
	});
	function find_random(num_one,num_two){
		return Math.random()*(num_two-num_one)+num_one;
	}
	(function() {
		var lastTime = 0;
		var vendors = ['webkit', 'moz'];
		for(var xx = 0; xx < vendors.length && !window.requestAnimationFrame; ++xx) {
			window.requestAnimationFrame = window[vendors[xx] + 'RequestAnimationFrame'];
			window.cancelAnimationFrame = window[vendors[xx] + 'CancelAnimationFrame'] ||
										  window[vendors[xx] + 'CancelRequestAnimationFrame'];
		}
	
		if (!window.requestAnimationFrame) {
			window.requestAnimationFrame = function(callback, element) {
				var currTime = new Date().getTime();
				var timeToCall = Math.max(0, 16.7 - (currTime - lastTime));
				var id = window.setTimeout(function() {
					callback(currTime + timeToCall);
				}, timeToCall);
				lastTime = currTime + timeToCall;
				return id;
			};
		}
		if (!window.cancelAnimationFrame) {
			window.cancelAnimationFrame = function(id) {
				clearTimeout(id);
			};
		}
	}());
	start();
});