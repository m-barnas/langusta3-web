import React, { Component } from 'react';

/**
 * Wrapper around Word components.
 */
export default class Words extends Component {
  constructor(props) {
    super(props);

    this.state = {
      selectedWord: null
    }

    this.handleWordClick = this.handleWordClick.bind(this);
  }
  /**
   * Deselects all words so that only one can be selected at once§.
   */
  handleWordClick(selectedWord) {
    let currentlySelectedWord = this.state.selectedWord;

    if (currentlySelectedWord !== null) {
      currentlySelectedWord.deselect();
    }

    this.setState({
      selectedWord: selectedWord
    });

    this.props.onWordSelect(selectedWord);
  }
  render() {
    return (
      <span>
        {this.props.children}
      </span>
    )
  }
}