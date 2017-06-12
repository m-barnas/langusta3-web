import { getFilterKeys } from './enums';

export const fetchBasePattern= (pattern) => {
  console.log(`Fetching base info for pattern: ${pattern}`);
  console.time('fetchBasePattern');

  return fetch(`PB138/langusta3/pattern/patternbase/${pattern}`).then((res) => {
    if (res.ok) {
      console.timeEnd('fetchBasePattern');
      return res.json();
    }
    throw new Error('Not ok');
  }, (err) => {
    console.log('fetch problem');
    throw err;
  }).catch((err) => {
    console.log('problem parsing response');
    throw err;
  });
}

export const fetchPatternsNames = () => {
  console.log('Fetching patterns names');
  console.time('fetchPatternsNames');

  return fetch(`PB138/langusta3/pattern/findall`).then((res) => {
    if (res.ok) {
      console.timeEnd('fetchPatternsNames');
      return res.json();
    }
    throw new Error('Not ok');
  }, (err) => {
    console.log('fetch problem');
    throw err;
  }).catch((err) => {
    console.log('problem parsing response');
    throw err;
  })
}

export const fetchPatterns = (word) => {
  console.log('Fetching patterns for word');
  console.time('fetchPatterns');

  return fetch(`PB138/langusta3/word/find-patterns?declined-value=${word}`).then((res) => {
    if (res.ok) {
      console.timeEnd('fetchPatterns');
      return res.json();
    }
    throw new Error('Not ok');
  }, (err) => {
    console.log('fetch problem');
    throw err;
  }).catch((err) => {
    console.log('problem parsing response');
    throw err;
  })
}

export const fetchAllPatterns = () => {
  console.log('Fetching all patterns');
  console.time('fetchAllPatterns');

  return fetch('PB138/langusta3/pattern/findall').then((res) => {
    if (res.ok) {
      console.timeEnd('fetchAllPatterns');
      return res.json();
    }
    throw new Error('Not ok');
  }, (err) => {
    console.log('fetch problem');
    throw err;
  }).catch((err) => {
    console.log('problem parsing response')
    throw err;
  })
}

export const fetchWordInfinitives = (pattern) => {
  console.log('Fetching word infinitives');
  console.time('fetchWordInfinitives');

  return fetch(`PB138/langusta3/word/find-infinitives?pattern=${pattern}`).then((res) => {
    if (res.ok) {
      console.timeEnd('fetchWordInfinitives');
      return res.json();
    }
    throw new Error('Not ok');
  }, (err) => {
    console.log('fetch problem');
    throw err;
  }).catch((err) => {
    console.log('problem parsing response');
    throw err;
  })
}

export const fetchWordOccurrences = (word) => {
  console.log('Fetching all word occurrences');
  console.time('fetchWordOccurrences');

  return fetch(`PB138/langusta3/word/find-by-declined-value?declined-value=${word}`).then((res) => {
    if (res.ok) {
      console.timeEnd('fetchWordOccurrences');
      return res.json();
    }
    throw new Error('Not ok');
  }, (err) => {
    console.log('fetch problem');
    throw err;
  }).catch((err) => {
    console.log('problem parsing response');
    throw err;
  })
}

export const fetchWordForms = (word, pattern) => {
  console.log('Fetching all forms for word and pattern');
  console.time('fetchWordForms');

  return fetch(`PB138/langusta3/word/find-all-forms?infinitive=${word}&pattern=${pattern}`).then((res) => {
    if (res.ok) {
      console.timeEnd('fetchWordForms');
      return res.json();
    }
    throw new Error('Not ok');
  }, (err) => {
    console.log('fetch problem');
    throw err;
  }).catch((err) => {
    console.log('problem parsing response');
    throw err;
  })
}

export const fetchAnalyzedWords = (str) => {
  console.log('Fetching analyzed words for string');
  console.time('fetchAnalyzedWords');

  return fetch(`PB138/langusta3/word/analyze?text=${str}`).then((res) => {
    if (res.ok) {
      console.timeEnd('fetchAnalyzedWords');
      return res.json();
    }
    throw new Error('Not ok');
  }, (err) => {
    console.log('fetch problem');
    throw err;
  }).catch((err) => {
    console.log('problem parsing response');
    throw err;
  })
}

export const fetchWordsByPatternCount = (count) => {
  console.log('Fetching word infinitives by pattern count');
  console.time('fetchWordsByPatternCount');

  return fetch(`PB138/langusta3/word/find-by-number-of-patterns?number-of-patterns=${count}`).then((res) => {
    if (res.ok) {
      console.timeEnd('fetchWordsByPatternCount');
      return res.json();
    }
    throw new Error('Not ok');
  }, (err) => {
    console.log('fetch problem');
    throw err;
  }).catch((err) => {
    console.log('problem parsing response');
    throw err;
  })
}

export const fetchWordsByPatterns = (patterns) => {
  console.log('Fetching word infinitives by patterns');
  console.time('fetchWordsByPatterns');

  let patternsStr = "";
  let str = "";

  patterns.forEach((item, index) => {
    str = `pattern=${item}`;
    if (index < patterns.length - 1) {
      str += "&";
    }

    patternsStr += str;
  })

  return fetch(`PB138/langusta3/word/find-words-by-patterns?${patternsStr}`).then((res) => {
    if (res.ok) {
      console.timeEnd('fetchWordsByPatterns');
      return res.json();
    }
    throw new Error('Not ok');
  }, (err) => {
    console.log('fetch problem');
    throw err;
  }).catch((err) => {
    console.log('problem parsing response');
    throw err;
  })
}

// possible filters are: pattern, wordClass, gender, number, grammaticalCase
export const fetchWordsByFilters = (match, filters) => {
  console.log('Fetching words by filters');
  console.time('fetchWordsByFilters');

  let filtersStr = "";

  if (typeof filters !== 'undefined') {
    const filterKeys = getFilterKeys();

    for (const key of filterKeys) {
      filtersStr += (filters[key] !== null && filters[key].length) ? `&${key}=${filters[key]}` : "";
    }
  }

  // console.log(filtersStr);

  // &pattern=${pattern}&word-class=${wordClass}&grammatical-gender=${gender}&number=${number}&grammatical-case=${grammaticalCase}
  return fetch(`/PB138/langusta3/word/filter?matches=${encodeURIComponent(match)}${filtersStr}`).then((res) => {
    if (res.ok) {
      console.timeEnd('fetchWordsByFilters');
      return res.json();
    }
    throw new Error('Not ok');
  }, (err) => {
    console.log('fetch problem');
    throw err;
  }).catch((err) => {
    console.log('problem parsing response: ');
    throw err;
  })
}
