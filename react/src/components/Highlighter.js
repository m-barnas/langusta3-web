/**
 * Modified react-highlight-words
 * https://github.com/bvaughn/react-highlight-words
 */
import { findAll } from 'highlight-words-core';
import PropTypes from 'prop-types';
import React, { Component } from 'react';
import Word from './Word';
import Words from './Words'

/**
 * Highlights all occurrences of search terms (searchText) within a string (textToHighlight).
 * This function returns an array of strings and <span>s (wrapping highlighted words).
 */
class Highlighter extends Component {
  constructor(props) {
    super(props);

    this.state = {
      activeClassName: this.props.activeClassName,
      activeIndex: this.props.activeIndex,
      autoEscape: this.props.autoEscape,
      className: this.props.className,
      highlightStyle: this.props.highlightStyle,
      sanitize: this.props.sanitize,
    }
  }
  render() {

    /**
     * Creates an array of chunk objects representing both higlightable and non highlightable pieces of text that match each search word.
     * @return Array of "chunks" (where a Chunk is { start:number, end:number, highlight:boolean })
     */
    const autoEscape = this.state.autoEscape;
    const sanitize = this.state.sanitize;
    const searchWords = this.props.searchWords;
    const textToHighlight = this.props.textToHighlight;

    const chunks = findAll({
      autoEscape,
      sanitize,
      searchWords,
      textToHighlight
    })

    return (
      <Words 
        className={this.state.className} 
        onWordSelect={this.props.onWordSelect}
        ref={(words) => {this.words = words}}
      >
        {chunks.map((chunk, index) => {
          const text = textToHighlight.substr(chunk.start, chunk.end - chunk.start)

          if (chunk.highlight) {
          
            return (
              <Word 
              className="Word Word--highlighted js-word"
              key={ index }
              style={ this.state.highlightStyle }
              onClick={ (selectedWord) => this.words.handleWordClick(selectedWord) }>
                {text}
              </Word>
            )
          } else {
            return (
              <span key={index}>{text}</span>
            )
          }
        })}
      </Words>
    )
  }
}

Highlighter.propTypes = {
  activeClassName: PropTypes.string,
  activeIndex: PropTypes.string,
  autoEscape: PropTypes.bool,
  className: PropTypes.string,
  highlightStyle: PropTypes.object,
  searchWords: PropTypes.arrayOf(PropTypes.string).isRequired,
  textToHighlight: PropTypes.string.isRequired,
  sanitize: PropTypes.func
}

Highlighter.defaultProps = {
  activeClassName: '',
  activeIndex: '-1',
  autoEscape: false,
  className: '',
  highlightStyle: {},
};

export default Highlighter;