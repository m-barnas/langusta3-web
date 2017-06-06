import React, { Component } from 'react';
import TagsInput from 'react-tagsinput';
// import 'react-tagsinput/react-tagsinput.css';
import AutosizeInput from 'react-input-autosize';
import Autosuggest from 'react-autosuggest';
import { MdClose } from 'react-icons/lib/md';

function states () {
  return [
    {abbr: 'AL', name: 'Alabama'},
    {abbr: 'AK', name: 'Alaska'},
    {abbr: 'AZ', name: 'Arizona'},
    {abbr: 'AR', name: 'Arkansas'},
    {abbr: 'CA', name: 'California'},
    {abbr: 'CO', name: 'Colorado'},
    {abbr: 'CT', name: 'Connecticut'},
    {abbr: 'DE', name: 'Delaware'},
    {abbr: 'FL', name: 'Florida'},
    {abbr: 'GA', name: 'Georgia'},
    {abbr: 'HI', name: 'Hawaii'},
    {abbr: 'ID', name: 'Idaho'},
    {abbr: 'IL', name: 'Illinois'},
    {abbr: 'IN', name: 'Indiana'},
    {abbr: 'IA', name: 'Iowa'},
    {abbr: 'KS', name: 'Kansas'},
    {abbr: 'KY', name: 'Kentucky'},
    {abbr: 'LA', name: 'Louisiana'},
    {abbr: 'ME', name: 'Maine'},
    {abbr: 'MD', name: 'Maryland'},
    {abbr: 'MA', name: 'Massachusetts'},
    {abbr: 'MI', name: 'Michigan'},
    {abbr: 'MN', name: 'Minnesota'},
    {abbr: 'MS', name: 'Mississippi'},
    {abbr: 'MO', name: 'Missouri'},
    {abbr: 'MT', name: 'Montana'},
    {abbr: 'NE', name: 'Nebraska'},
    {abbr: 'NV', name: 'Nevada'},
    {abbr: 'NH', name: 'New Hampshire'},
    {abbr: 'NJ', name: 'New Jersey'},
    {abbr: 'NM', name: 'New Mexico'},
    {abbr: 'NY', name: 'New York'},
    {abbr: 'NC', name: 'North Carolina'},
    {abbr: 'ND', name: 'North Dakota'},
    {abbr: 'OH', name: 'Ohio'},
    {abbr: 'OK', name: 'Oklahoma'},
    {abbr: 'OR', name: 'Oregon'},
    {abbr: 'PA', name: 'Pennsylvania'},
    {abbr: 'RI', name: 'Rhode Island'},
    {abbr: 'SC', name: 'South Carolina'},
    {abbr: 'SD', name: 'South Dakota'},
    {abbr: 'TN', name: 'Tennessee'},
    {abbr: 'TX', name: 'Texas'},
    {abbr: 'UT', name: 'Utah'},
    {abbr: 'VT', name: 'Vermont'},
    {abbr: 'VA', name: 'Virginia'},
    {abbr: 'WA', name: 'Washington'},
    {abbr: 'WV', name: 'West Virginia'},
    {abbr: 'WI', name: 'Wisconsin'},
    {abbr: 'WY', name: 'Wyoming'}
  ]
}

export default class PatternSearch extends Component {
  constructor(props) {
    super(props);

    this.state = {
      tags: []
    }

    this.handleChange = this.handleChange.bind(this);
  }
  handleChange(tags) {
    this.setState({tags})
  }
  render() {
    function autosizingRenderInput ({addTag, ...props}) {
      let {onChange, value, ...other} = props
      return (
        <AutosizeInput type='text' onChange={onChange} value={value} {...other} />
      )
    }
    function renderTag (props) {
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
    function autosuggestRenderInput ({addTag, ...props}) {
      const handleOnChange = (e, {newValue, method}) => {
        if (method === 'enter') {
          e.preventDefault()
        } else {
          props.onChange(e)
        }
      }
    
      const inputValue = (props.value && props.value.trim().toLowerCase()) || ''
      const inputLength = inputValue.length
    
      let suggestions = states().filter((state) => {
        return state.name.toLowerCase().slice(0, inputLength) === inputValue
      })
    
      return (
        <Autosuggest
          ref={props.ref}
          suggestions={suggestions}
          shouldRenderSuggestions={(value) => value && value.trim().length > 0}
          getSuggestionValue={(suggestion) => suggestion.name}
          renderSuggestion={(suggestion) => <span>{suggestion.name}</span>}
          inputProps={{...props, onChange: handleOnChange}}
          onSuggestionSelected={(e, {suggestion}) => {
            addTag(suggestion.name)
          }}
          onSuggestionsClearRequested={() => {}}
          onSuggestionsFetchRequested={() => {}}
          renderInputComponent={autosizingRenderInput}
        />
      )
    }

    return (
      <main className="PatternSearch">
        <div className="Container pv5">
          <h1 className="tc mt0">Pattern search</h1>
          <div className="mw7 center">
            <TagsInput 
              renderInput={autosuggestRenderInput}
              renderTag={renderTag}
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