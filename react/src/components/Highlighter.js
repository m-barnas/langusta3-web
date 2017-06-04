/**
 * Modified react-highlight-words
 * https://github.com/bvaughn/react-highlight-words
 */
import { findAll } from 'highlight-words-core';
import PropTypes from 'prop-types';
import React, { Component } from 'react';

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
      highlightClassName: this.props.highlightClassName,
      highlightTag: this.props.highlightTag,
      highlightStyle: this.props.highlightStyle,
      sanitize: this.props.sanitize,
    }

    this.handleHighlightClick = this.handleHighlightClick.bind(this);
  }
  handleHighlightClick(event) {
    let target = event.target;
    console.log(target);
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
    const HighlightTag = this.state.highlightTag
    let highlightCount = -1
    let highlightClassNames = ''

    return (
      <span className={this.state.className}>
        {chunks.map((chunk, index) => {
          const text = textToHighlight.substr(chunk.start, chunk.end - chunk.start)

          if (chunk.highlight) {
            highlightCount++
            highlightClassNames = `${this.state.highlightClassName} ${highlightCount === +this.stateactiveIndex ? this.state.activeClassName : ''}`

            return (
              <HighlightTag
                className={highlightClassNames}
                key={index}
                style={this.state.highlightStyle}
                tabIndex='0'
                onClick={this.handleHighlightClick}
              >
                {text}
              </HighlightTag>
            )
          } else {
            return (
              <span key={index}>{text}</span>
            )
          }
        })}
      </span>
    )
  }
}

Highlighter.propTypes = {
  activeClassName: PropTypes.string,
  activeIndex: PropTypes.string,
  autoEscape: PropTypes.bool,
  className: PropTypes.string,
  highlightClassName: PropTypes.string,
  highlightTag: PropTypes.string,
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
  highlightClassName: '',
  highlightStyle: {},
  highlightTag: 'mark',
};

export default Highlighter;