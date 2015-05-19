var markdownpdf = require('markdown-pdf')
 
var options = { 
	cssPath: "style.css",
	runningsPath: "runnings.js",
    remarkable: {
        html: true,
        breaks: true,
        plugins: [ require('remarkable-classy') ]
    }
}

fileIn = process.argv[2]
fileOut = process.argv[2].replace(/\.m(ark)?d(own)?/gi, "") + ".pdf"

console.log("Processing " + fileIn)

markdownpdf(options)
  .from(fileIn)
  .to(fileOut, function (er) { if (er) throw er })
