let reactCount = 0;
const myComponent = (props) => {
  return React.createElement("p", null, `${props.message}: ${props.count}`)
}

const container = document.getElementById('count-view-03');
const root = ReactDOM.createRoot(container); // createRoot(container!) if you use TypeScript
root.render(React.createElement(myComponent, {message: "Count", count: reactCount}))

const button03 = document.getElementById("count-btn-03")
button03.addEventListener('click', (ev) => {
  root.render(React.createElement(myComponent, {message: "Count", count: reactCount++}))
})


class Welcome extends React.Component {
  render() {
    return <h4>Hello, {this.props.name}</h4>;
  }
}

const componentRoot = ReactDOM.createRoot(document.getElementById('count-view-04'));
const element = <Welcome name="Juyong" />;
componentRoot.render(element);
