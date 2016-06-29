$(document).ready(function() {
	$("#inventory tr.asset-row").each(function(index, row) {
		setupAssetsRow($(row));
	});

	setupDatePicker();
	removeRow();
	
	function setupAssetsRow(row) {
		var name = row.find(".asset-name");
		var serie = row.find(".asset-serie");
		
		name.change(function() {
			$.post("assets", 
					{
						name : name.val()
					}, 
					function(assets) {
						serie.empty();
						for(var i = 0; i < assets.length; i++) {
							var option = $("<option></option>")
								.attr("value", assets[i].id)
								.text(assets[i].serie);
							serie.append(option);
						}
					});
		});
		name.change();
	};
	
	function setupDatePicker() {
		$("#inventory .datepicker").datepicker({
	        format: 'mm/dd/yyyy',
	        todayHighlight: true,
	        autoclose: true,
	    });
	};
	
	$(".plusbtn").click(function (){
		var template = $(".asset-row-template");
		var row = template.clone();
		
		row.removeClass("hidden asset-row-template");
		row.insertBefore(template);
		
		var lastIndex = $("#inventory .asset-row").length - 2;
		row.find(".asset-name").attr("name", "inventoryList[" + lastIndex +"].assetName");
		row.find(".asset-serie").attr("name", "inventoryList[" + lastIndex +"].assetSerie");
		row.find(".use-time").attr("name", "inventoryList[" + lastIndex +"].useTime");
		row.find(".pu").attr("name", "inventoryList[" + lastIndex +"].pu");
		row.find(".um").attr("name", "inventoryList[" + lastIndex +"].um");
		row.find(".reception-date").attr("name", "inventoryList[" + lastIndex +"].receptionDate");
		row.find(".reception-type").attr("name", "inventoryList[" + lastIndex +"].receptionType");
		row.find(".reception-number").attr("name", "inventoryList[" + lastIndex +"].receptionNumber");
		row.find(".reception-quantity").attr("name", "inventoryList[" + lastIndex +"].receptionQuantity");
		row.find(".returning-date").attr("name", "inventoryList[" + lastIndex +"].returningDate");
		row.find(".returning-type").attr("name", "inventoryList[" + lastIndex +"].returningType");
		row.find(".returning-number").attr("name", "inventoryList[" + lastIndex +"].returningnNumber");
		row.find(".returning-quantity").attr("name", "inventoryList[" + lastIndex +"].returningQuantity");
		
		setupAssetsRow(row);
		setupDatePicker();
		removeRow();
	});
	
	function removeRow(){
		$(".remove-row-btn").click(function(){
			$(this).closest('tr').remove();
		});
	};
	
});