let count = 0;
const button = document.getElementById("count-btn");
const view = document.getElementById("count-view");
view.innerHTML = "<p>Count: 0</p>"

button.addEventListener("click", (ev) => {
  view.innerHTML = `<p>Count: ${++count}</p>`
})

const button02 = document.querySelector('#count-btn-02');
const view02 = document.querySelector('#count-view-02');

const component = {
  message: "Count",
  count: 0,
  render() {
    return `<p>${this.message}: ${this.count}</p>`
  }
}

function render(rootElement, component) {
  rootElement.innerHTML = component.render()
}

render(view02, component)

button02.addEventListener("click", (ev) => {
  component.count++;
  render(view02, component)
});
