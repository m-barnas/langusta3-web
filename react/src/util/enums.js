export const getGrammaticalCases = () => {
  return ['Nominative', 'Genitive', 'Dative', 'Accusative', 'Vocative', 'Locative', 'Instrumental'];
}
export const getNumbers = () => {
  return ['Singular', 'Plural'];
}
export const getWordClasses = () => {
  return ['Noun', 'Verb', 'Adjective', 'Adverb', 'Pronoun','Preposition']
}
export const getGrammaticalGenders = () => {
  return ['MasculineAnimate', 'MasculineInanimate', 'Feminine', 'Neuter']
}
export const getFilterKeys = () => {
  return ['pattern', 'word-class', 'gender', 'number', 'grammatical-case']
}