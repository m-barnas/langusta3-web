import React, { Component } from 'react';
import TagsInput from 'react-tagsinput';
// import 'react-tagsinput/react-tagsinput.css';
import AutosizeInput from 'react-input-autosize';
import Autosuggest from 'react-autosuggest';
import { MdClose } from 'react-icons/lib/md';
import { fetchAllPatterns } from '../util/api';

export default class PatternSearch extends Component {
  constructor(props) {
    super(props);

    this.state = {
      tags: [],
      patterns: []
    }

    this.handleChange = this.handleChange.bind(this);
    this.autosizingRenderInput = this.autosizingRenderInput.bind(this);
    this.renderTag = this.renderTag.bind(this);
    this.autosuggestRenderInput = this.autosuggestRenderInput.bind(this);
  }
  componentDidMount() {
    let data = fetchAllPatterns();
    let patterns = [];

    data.then((data) => {
      for (let obj of data) {
        patterns.push(obj.id);
      }
      this.state = {
        patterns: patterns
      }
    });
  }
  handleChange(tags) {
    this.setState({tags})
  }
  autosizingRenderInput ({addTag, ...props}) {
    let {onChange, value, ...other} = props
    return (
      <AutosizeInput type='text' onChange={onChange} value={value} {...other} />
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
  
    const inputValue = (props.value && props.value.trim().toLowerCase()) || ''
    const inputLength = inputValue.length
  
    let suggestions = this.state.patterns.filter((item) => {
      return item.toLowerCase().slice(0, inputLength) === inputValue
    });
  
    return (
      <Autosuggest
        ref={props.ref}
        suggestions={suggestions}
        shouldRenderSuggestions={(value) => value && value.trim().length > 0}
        getSuggestionValue={(suggestion) => suggestion}
        renderSuggestion={(suggestion) => <span>{suggestion}</span>}
        inputProps={{...props, onChange: handleOnChange}}
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
    return (
      <main className="PatternSearch">
        <div className="Container pv5">
          <h1 className="tc mt0">Pattern search</h1>
          <div className="mw7 center">
            <TagsInput 
              renderInput={this.autosuggestRenderInput}
              renderTag={this.renderTag}
              value={this.state.tags} 
              onChange={this.handleChange}
              className="TagPicker FormControl"
              focusedClassName="is-focused"
              inputProps={{
                className: "TagPicker-input",
                placeholder: "Add a pattern "
              }}
              tagProps={{
                className: 'Tag', 
                classNameRemove: 'Tag-remove'
              }}
              onlyUnique={true}
            />
            </div>
        </div>
      </main>
    )
  }
}