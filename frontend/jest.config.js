module.exports = {
  preset: '@vue/cli-plugin-unit-jest',
  reporters: [
    'default',
    ['jest-junit', { outputDirectory: 'test-results', outputName: 'report.xml' }],
  ],
  moduleNameMapper: {
    '^@/(.*)$': '<rootDir>/src/$1',
  },
  transform: {
    '^.+\\.vue$': '@vue/vue3-jest',
    '^.+\\.js$': 'babel-jest'
  },
  transformIgnorePatterns: [
    '^/node_modules/(?!axios)',
  ],
};
