// interval.js(Date 객에에 두 시점의 날짜 계산하는 getInterval함수 추가)

Date.prototype.getInterval = function(otherday){
    var intervalMilli = Math.max(this.getTime(),otherday.getTime())-Math.min(this.getTime(),otherday.getTime());
    var intervalDay = Math.floor(intervalMilli/(1000*60*60*24));
    return intervalDay;
};