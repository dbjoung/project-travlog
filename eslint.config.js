import js from '@eslint/js';
import globals from 'globals';
import reactHooks from 'eslint-plugin-react-hooks';
import reactRefresh from 'eslint-plugin-react-refresh';
import tseslint from 'typescript-eslint';
import prettier from 'eslint-plugin-prettier';
import configPrettier from 'eslint-config-prettier';
import parser from '@typescript-eslint/parser';

export default tseslint.config(
  { ignores: ['dist'] },
  {
    files: ['**/*.{ts,tsx,json}'],
    languageOptions: {
      parser, // 🔥 이 줄이 꼭 필요해
      ecmaVersion: 2020,
      globals: globals.browser,
      sourceType: 'module',
    },
    plugins: {
      'react-hooks': reactHooks,
      'react-refresh': reactRefresh,
      prettier: prettier,
    },
    rules: {
      ...reactHooks.configs.recommended.rules,
      'react-refresh/only-export-components': ['warn', { allowConstantExport: true }],
      'prettier/prettier': [
        'error',
        {
          endOfLine: 'auto',
        },
      ], // Prettier 룰을 ESLint 규칙으로 실행
    },
    // Prettier와 충돌나는 룰 제거
    settings: {},
  },
  {
    // config-prettier를 마지막에 확장하여 충돌 방지
    name: 'prettier-config',
    rules: configPrettier.rules,
  },
);
