import React, {Component} from 'react';

export default class Pattern extends Component {
  constructor(props) {
    super(props);

    this.state = {
      data: this.props.data
    }
  }
  render() {
    return React.Children.only(this.props.children);
  }
}