import React, { Component } from 'react';
import TagsInput from 'react-tagsinput';
// import 'react-tagsinput/react-tagsinput.css';
import AutosizeInput from 'react-input-autosize';
import Autosuggest from 'react-autosuggest';
// import ReactTooltip from 'react-tooltip';
import { MdClose, MdRefresh } from 'react-icons/lib/md';
import { fetchAllPatterns, fetchWordsByPatterns } from '../util/api';

export default class PatternSearch extends Component {
  constructor(props) {
    super(props);

    this.state = {
      isLoading: false,
      tags: [],
      patterns: [],
      words: null
    }

    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.handleClick = this.handleClick.bind(this);
    this.focus = this.focus.bind(this);
    this.autosizingRenderInput = this.autosizingRenderInput.bind(this);
    this.renderTag = this.renderTag.bind(this);
    this.autosuggestRenderInput = this.autosuggestRenderInput.bind(this);
  }
  componentDidMount() {
    let data = fetchAllPatterns();
    let patterns = [];

    data.then((data) => {
      for (let obj of data) {
        patterns.push(obj);
      }
      this.state = {
        patterns: patterns
      }
    });
  }
  handleSubmit(event) {
    event.preventDefault();

    if (typeof this.state.tags !== 'undefined' && this.state.tags.length) {
      this.setState({
        isLoading: true
      })

      fetchWordsByPatterns(this.state.tags).then((data) => {
        this.setState({
          isLoading: false,
          words: data
        })
      })
    }
  }
  handleChange(tags) {
    this.setState({tags})
  }
  handleClick(event) {
  }
  focus(event) {
    this.input.refs.input.input.focus();
  }
  autosizingRenderInput ({addTag, ...props}) {
    let {onChange, value, ...other} = props
    return (
      <AutosizeInput ref={props.ref} type='text' onChange={onChange} value={value} {...other}/>
    )
  }
  renderTag (props) {
    let {tag, key, disabled, onRemove, classNameRemove, getTagDisplayValue, ...other} = props

    return (
      <span key={key} {...other}>
        {getTagDisplayValue(tag)}
        {!disabled &&
          <a className={classNameRemove} onClick={(e) => onRemove(key)}>
            <MdClose />
          </a>
        }
      </span>
    )
  }
  autosuggestRenderInput ({addTag, ...props}) {
    const handleOnChange = (e, {newValue, method}) => {
      if (method === 'enter') {
        e.preventDefault()
      } else {
        props.onChange(e)
      }
    }

    const handleKeyDown = (event) => {
      if (event.key === 'Enter') {
        event.preventDefault();
        const value = event.target.value;

        // only add tag if input value is a valid pattern
        if (this.state.patterns.find((item) => {
          return item === value
        })) {
          addTag(value);
        }
      }
      if (event.key === 'Backspace' && !event.target.value.length) {
        if (typeof this.state.tags !== 'undefined' && this.state.tags.length) {
          this.state.tags.length--;
          this.forceUpdate();
        }
      }
    }

    const filterSelected = (item) => {
      // react doesn't add empty array to state when mounting component
      // check if state contains tags and if they're not empty
      if (typeof this.state.tags !== 'undefined' && this.state.tags.length) {
        for (let tag of this.state.tags) {
          if (item === tag) {
            return false
          }
        }
      }

      return true;
    }

    const inputValue = (props.value && props.value.trim().toLowerCase()) || ''
    const inputLength = inputValue.length

    let suggestions = this.state.patterns.filter((item) => {
      return (item.toLowerCase().slice(0, inputLength) === inputValue &&
        filterSelected(item))
    })

    return (
      <Autosuggest
        ref={props.ref}
        suggestions={suggestions}
        shouldRenderSuggestions={(value) => value && value.trim().length > 0}
        getSuggestionValue={(suggestion) => suggestion}
        renderSuggestion={(suggestion) => <span>{suggestion}</span>}
        inputProps={{...props, onChange: handleOnChange, onKeyDown: handleKeyDown}}
        onSuggestionSelected={(e, {suggestion}) => {
          addTag(suggestion)
        }}
        onSuggestionsClearRequested={() => {}}
        onSuggestionsFetchRequested={() => {}}
        renderInputComponent={this.autosizingRenderInput}
      />
    )
  }
  render() {
    const words = this.state.words;

    return (
      <main className="PatternSearch">
        <div className="Container pv5">
          <h1 className="tc mt0 lh-title">Vyhľadávanie podľa vzorov</h1>
          <form className="flex-ns items-start mw7 center cf" onSubmit={this.handleSubmit}>
            <TagsInput
              renderInput={this.autosuggestRenderInput}
              renderTag={this.renderTag}
              value={this.state.tags}
              onChange={this.handleChange}
              className={"TagPicker FormControl flex-auto" + (this.state.isLoading ? " is-loading" : "")}
              focusedClassName="is-focused"
              inputProps={{
                className: "TagPicker-input",
                placeholder: "Add a pattern ",
                onFocus: this.focus
              }}
              tagProps={{
                className: 'Tag',
                classNameRemove: 'Tag-remove'
              }}
              onlyUnique={true}
              ref={(input) => {this.input = input}}
              disabled={this.state.isLoading}
            />
            <button className={"TagPicker-button Button Button--primary fr fn-ns ml3 mt2 mt0-ns nowrap" + (this.state.isLoading ? " is-loading" : "")}
            type="submit" disabled={this.state.isLoading}>
              <MdRefresh className="Button-icon mr1" />Hľadať
            </button>
          </form>
          { words !== null && typeof words !== 'undefined' &&
            <div className="mw7 center mt3">
              <div className="mb2">Počet slov: <strong>{words.length}</strong></div>
              <div className={"AnalysisResult AnalysisResult--lg FormControl overflow-y-auto bg-near-white" + (this.state.isLoading ? " is-loading" : "")}>
                {words.map((item, index) => {
                  return <span className="mr2" key={index}>{item} </span>
                })}
              </div>
            </div>
          }
          {/*<ReactTooltip class="Tooltip" effect="solid" html={true}/>*/}
        </div>
      </main>
    )
  }
}
