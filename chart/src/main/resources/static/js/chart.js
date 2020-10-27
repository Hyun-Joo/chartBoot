$(document).ready(function(){
	drawTable();
});

const drawTable = async () => {
	
	let res = await axios.post('/chart/getData',"");
	console.log(res);
	
	if(res.status == 200){
		let data = res.data;
		let list = data.list;
		$('#elapsedTime').html(data.time+' sec').css('color','red').css('background','yellow');
		list.forEach(item => {
			$('<tr>')
			.append($('<td>').html(item.cdNm))
			.append($('<td>').html(item.regionArea))
			.append($('<td>').html(item.c00))
			.append($('<td>').html(item.c01))
			.append($('<td>').html(item.c02))
			.append($('<td>').html(item.c03))
			.append($('<td>').html(item.c04))
			.append($('<td>').html(item.c05))
			.append($('<td>').html(item.c06))
			.append($('<td>').html(item.c07))
			.append($('<td>').html(item.c08))
			.append($('<td>').html(item.c09))
			.append($('<td>').html(item.tot))
			//.append($('<td>').html(item.gr))
			.appendTo('#chartBody');
			
			$('td:contains("▲")').css('color', getColor('TOP_COLOR')).css('font-weight', 600);
			$('td:contains("▼")').css('color', getColor('LAST_COLOR')).css('font-weight', 600);
			
			$('#chartBody > tr:contains("합계")')
						.css('background', getColor('M_BK_COLOR'))
						.css('font-weight', 600);
			$('#chartBody > tr:contains("총계")')
						.css('background', getColor('T_BK_COLOR'))
						.css('font-weight', 600);
		});
	}
	
}

const getColor = (cdId) => {
	let color = colorList.filter(col => col.cdId == cdId)[0].cmt;
	return color;
}