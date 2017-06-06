import React, { Component } from 'react';

/**
 * Wrapper around Word components.
 */
export default class Words extends Component {
  constructor(props) {
    super(props);

    this.wordRefs = this.props.wordRefs;
    this.handleWordClick = this.handleWordClick.bind(this);
  }
  /**
   * Deselects all words so that only one can be selected at once.
   */
  handleWordClick() {
    Array.from(this.wordRefs.values())
      .filter(word => word != null)
      .forEach(word => {
        word.deselect();
      });
  }
  render() {
    return (
      <span>
        {this.props.children}
      </span>
    )
  }
}