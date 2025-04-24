({
  // Please visit the URL below for more information:
  // https://shd101wyy.github.io/markdown-preview-enhanced/#/extend-parser

  onWillParseMarkdown: async function(markdown) {
    return markdown.replace(
          /<!--\s*@include:\s*(.+)\s*-->/g,
          (match, p1) => `@import "${p1.trim()}"`
        ); 
  },

  onDidParseMarkdown: async function(html) {
    return html;
  },
})