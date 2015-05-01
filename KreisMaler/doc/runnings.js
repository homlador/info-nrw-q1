exports.header = null

exports.footer = {
	height: "1cm",
	contents: function(pageNum, numPages) {
		return "<h4><span style='float:right'> Seite " + pageNum + " / " + numPages + "</span></h4>"
	}
}
